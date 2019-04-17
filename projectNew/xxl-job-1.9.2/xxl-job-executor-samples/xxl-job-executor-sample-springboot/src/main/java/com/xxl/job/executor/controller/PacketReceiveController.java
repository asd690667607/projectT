package com.xxl.job.executor.controller;


import com.xxl.job.executor.common.result.ResultJson;
import com.xxl.job.executor.domain.orm.*;
import com.xxl.job.executor.service.IPacketReceiveService;
import com.xxl.job.executor.service.IPacketSendService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/receive")
public class PacketReceiveController {
    @Autowired
    private IPacketReceiveService packetReceiveService;
    @Autowired
    private IPacketSendService packetSendService;
    @ApiOperation(value = "丁兆双: 抢红包", notes = "")
    @GetMapping(value = "grapRedPacket")
    public ResultJson grapRedPacket(int redPacketId, int toUserId){
        PacketSend packetSend= packetSendService.getRedPacket(redPacketId);
        if(packetSend ==null){
            return  ResultJson.createByErrorMsg("无效红包");
        }
        //抢过该红包的用户列表
        List<User> list=packetReceiveService.getUserlist(redPacketId);
        String uId= String.valueOf(toUserId);
        if(list.contains(uId))
        {
            return  ResultJson.createByErrorMsg("您已经抢过该红包");
        }
        if (packetSend.getStock()==0)
        {
            return  ResultJson.createByErrorMsg("红包已抢光");
        }
        if (packetSend.getRedPacketStatus()==4)
        {
            return  ResultJson.createByErrorMsg("该红包已过期");
        }
        if(packetSend.getUserId()==toUserId)
        {
            return  ResultJson.createByErrorMsg("发送者无法抢夺红包");
        }
        boolean flag = false;
        try{
        int   result = packetReceiveService.grapRedPacketForVersion(redPacketId,toUserId);
         flag = result > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  ResultJson.createBySuccess("",flag);
    }
}
