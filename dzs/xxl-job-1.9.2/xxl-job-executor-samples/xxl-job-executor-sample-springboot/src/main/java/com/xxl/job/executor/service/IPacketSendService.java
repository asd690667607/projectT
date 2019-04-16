package com.xxl.job.executor.service;

import com.xxl.job.executor.domain.orm.Bill;
import com.xxl.job.executor.domain.orm.PacketSend;
import com.xxl.job.executor.domain.orm.Wallet;

import java.util.List;

public interface IPacketSendService {

    /**
     * 获取红包
     * @param id ——编号
     * @return 红包信息
     */
    PacketSend getRedPacket(int id);


    /**
     * 发红包
     * @param packetSend——红包
     * @return 影响条数.
     */
    int insertPacket(PacketSend packetSend);
    /**
     * 查询钱包
     * @param
     * @return 更新记录条数
     */
    Wallet getWallet(int userId);

}
