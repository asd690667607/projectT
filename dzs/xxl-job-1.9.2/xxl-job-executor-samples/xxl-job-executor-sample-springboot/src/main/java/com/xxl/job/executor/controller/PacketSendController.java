package com.xxl.job.executor.controller;
import com.xxl.job.executor.common.result.ResultJson;
import com.xxl.job.executor.domain.orm.PacketSend;
import com.xxl.job.executor.domain.orm.Wallet;
import com.xxl.job.executor.service.IPacketSendService;
import com.xxl.job.executor.util.RedBagUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/send")
public class PacketSendController {
    @Autowired
    private IPacketSendService packetSendService;
    @Autowired
    private RedisTemplate redisTemplate;
    @ApiOperation(value = "丁兆双: 发送红包", notes = "")
    @GetMapping(value = "packetSend")
        public ResultJson insertPacket(PacketSend packetSend){
        //获取用户钱包
        int userId =packetSend.getUserId();
        BigDecimal amount = packetSend.getAmount();
        int count = packetSend.getRedPacketCount();
        int redPacketType = packetSend.getRedPacketType();
        packetSend.setStock(count);
        packetSend.setRedPacketStatus(1);
        BigDecimal receiveAmount = new BigDecimal("0");
        packetSend.setReceiveAmount(receiveAmount);
        //获取用户钱包
        Wallet wallet =packetSendService.getWallet(userId);
        //获取钱包余额
        BigDecimal availableBalance= wallet.getAmount();
        //发送金额上限为50
        BigDecimal amountMax = new BigDecimal("50");
        //金额大于0
        BigDecimal amountMin = new BigDecimal("0");
        //设置单个红包最低金额
        BigDecimal amountMinn = new BigDecimal("0.01");

            if (amount.compareTo(amountMax) > 0) {
                return ResultJson.createByErrorMsg("红包上限为50元");
            }
            if (amount.compareTo(amountMin) <= 0) {
                return ResultJson.createByErrorMsg("请输入有效金额");
            }
            if (count >= 100 || count < 0) {
                return ResultJson.createByErrorMsg("红包上限100个");
            }
            int r = availableBalance.compareTo(amount);
            if (r < 0) {
                return ResultJson.createByErrorMsg("余额不足");
            }
            BigDecimal newCount = new BigDecimal(count);
            //类型为普通红包
        if(redPacketType ==2) {
            if( amount.compareTo(amountMinn) < 0){
                return  ResultJson.createByErrorMsg("单个红包金额不得低于0.01元");
            }
        }
        //类型为运气红包
        if(redPacketType ==1) {
            //精确到两位小数，截取
            if(amount.divide(newCount,2,BigDecimal.ROUND_DOWN).compareTo(amountMinn)< 0)
          {
              return  ResultJson.createByErrorMsg("单个红包金额不得低于0.01元");
          }
        }
            int result = packetSendService.insertPacket(packetSend);

            if (result <= 0) {
                return ResultJson.createByErrorMsg("Error");
            }
        //存入发红包信息Id到redis中
        redisTemplate.opsForList().leftPush("redPacketId",packetSend.getId());
        if(redPacketType ==1){
            List<BigDecimal> list= RedBagUtils.math(packetSend.getAmount(),count);
            System.out.println("list"+list);
            for (int i = 0; i <  count; i++) {
                redisTemplate.opsForList().leftPush("list"+packetSend.getId(),list.get(i));
            }
        }
        return  ResultJson.createBySuccess("redPacketId",packetSend.getId());
    }
}
