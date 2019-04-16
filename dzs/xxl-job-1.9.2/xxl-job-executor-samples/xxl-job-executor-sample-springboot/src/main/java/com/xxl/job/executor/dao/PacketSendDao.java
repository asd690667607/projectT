package com.xxl.job.executor.dao;

import com.xxl.job.executor.domain.orm.Bill;
import com.xxl.job.executor.domain.orm.PacketSend;
import com.xxl.job.executor.domain.orm.User;
import com.xxl.job.executor.domain.orm.Wallet;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PacketSendDao {
    /**
     * 获取红包信息.
     * @param id --红包id
     * @return 红包具体信息
     */
     PacketSend getRedPacket(int id);

    /**
     * 扣减抢红包数.
     * @param id -- 红包id
     * @return 更新记录条数
     */
     int decreaseRedPacket(int id);
    /**
     * 获取红包信息. 悲观锁的实现方式
     *
     * @param id
     *            --红包id
     * @return 红包具体信息
     */
     PacketSend getRedPacketForUpdate(int id);

    /**
     * @Description: 扣减抢红包数. 乐观锁的实现方式
     *
     * @param id
     *            -- 红包id
     * @param version
     *            -- 版本标记
     *
     * @return: 更新记录条数
     */
     int decreaseRedPacketForVersion(@Param("id") int id);
    /**
     *
     * @param packetSend
     *            -- 红包
     *
     * @return: 更新记录条数
     */
    int insertPacket(PacketSend packetSend);
    /**
     * 更新余额
     * @param
     * @return 更新记录条数
     */
    int updateWallet(Wallet wallet);
    /**
     * 查询钱包
     * @param
     * @return 更新记录条数
     */
    Wallet getWallet(int userId);
    /**
     * 记录账单
     */
    int insertBill(Bill bill);
    /**
     * 更新红包状态
     * @param
     * @return 更新记录条数
     */
    int updateRedPacket(@Param("id") int id,@Param("redPacketStatus") int redPacketStatus);

    /**
     *查询所有发红包信息
     * @
     * @return
     */
    List<PacketSend> getPacketSend();
}
