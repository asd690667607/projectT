package com.xxl.job.executor.service.jobhandler;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.dao.PacketSendDao;
import com.xxl.job.executor.domain.orm.Bill;
import com.xxl.job.executor.domain.orm.PacketSend;
import com.xxl.job.executor.domain.orm.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@JobHandler(value="refundJobHandler")
@Component
public class RefundJobHandler extends IJobHandler {
    @Autowired
    private PacketSendDao packetSendDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    @Transactional(rollbackFor={SQLException.class},isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("执行退款");
        if(redisTemplate.opsForList().index("redPacketId",-1)!=null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            //当前时间
            Long newTime = Long.valueOf(df.format(new Date()));
            //获取缓存中红包ID列表
            List<Integer> idList= redisTemplate.opsForList().range("redPacketId",0,-1);
                // 过了十分钟且状态不是退回状态
            for(int j = idList.size()-1; j>=0;j--)
            { int  redPacketId=(Integer)   redisTemplate.opsForList().rightPop("redPacketId");
            PacketSend packetSend = packetSendDao.getRedPacket(redPacketId);
            if(newTime-packetSend.getCreateTime()<10){
                //添加回redis
                redisTemplate.opsForList().rightPush("redPacketId",packetSend.getId());
                break;

                  }
                else  {
                    //红包还有库存
                    if(  packetSend.getRedPacketStatus() != 3)
                    {
                    //红包库存
                    int stock = packetSend.getStock();
                    //红包Id
                    int id = packetSend.getId();
                    //红包总数
                    BigDecimal amountAll = new BigDecimal("0");
                    packetSend.setRedPacketStatus(4);
                    int redPacketType = packetSend.getRedPacketType();
                    //普通红包
                    if (redPacketType == 2) {
                        BigDecimal a = new BigDecimal(packetSend.getStock());
                        amountAll = packetSend.getAmount().multiply(a);
                    } else {
                        for (int i =0; i < stock; i++) {
                            String listValue = redisTemplate.opsForList().rightPop("list"+packetSend.getId()) + "";
                            BigDecimal bd = new BigDecimal(listValue);
                            amountAll = amountAll.add(bd);
                        }
                    }
                        System.out.println(amountAll);
                    //得到发红包的用户 用户钱包
                    Wallet wallet = packetSendDao.getWallet(packetSend.getUserId());
                    //更新用户钱包金额r<=0
                       BigDecimal newAmountAll= wallet.getAmount().add(amountAll);
                    wallet.setAmount(newAmountAll);
                    int result = packetSendDao.updateWallet(wallet);
                    int redPacketStatus = 4;
                    int re = packetSendDao.updateRedPacket(id, redPacketStatus);
                        //新建一个账单
                        Bill bill = new Bill();
                        bill.setUserId(packetSend.getUserId());
                        bill.setAvailableBalance(newAmountAll);
                        bill.setAvailableVariation(amountAll);
                        bill.setBillExplain("退回红包");
                        bill.setWalletId(wallet.getId());
                        //记录账单
                        int r= packetSendDao.insertBill(bill);
                    if (result <= 0 || re <= 0 ||r<=0) {
                        throw new RuntimeException();
                                             }
                           }

                           }

                                 }
        }
                        return SUCCESS;

                              }
                             }