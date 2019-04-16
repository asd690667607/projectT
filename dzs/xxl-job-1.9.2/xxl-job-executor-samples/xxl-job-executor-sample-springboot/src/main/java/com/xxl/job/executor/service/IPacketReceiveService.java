package com.xxl.job.executor.service;

import com.xxl.job.executor.domain.orm.PacketReceive;
import com.xxl.job.executor.domain.orm.User;
import java.util.List;

public interface IPacketReceiveService {


    /**
     * 保存抢红包信息. 乐观锁的方式
     *
     * @param redPacketId
     *            红包编号
     * @param toUserId
     *            抢红包用户编号
     * @return 影响记录数.
     */
     int grapRedPacketForVersion(int redPacketId, int toUserId) throws Exception;

    /**
     *查询抢过红包的用户列表
     * @param redPacketId ——红包Id
     * @return 影响记录数.
     */
    List<User> getUserlist(int redPacketId);
    /**
     *查询抢过红包的信息
     * @param toUserId ——用户Id
     * @return 影响记录数.
     */
    PacketReceive getPacketReceive(int toUserId, int redPacketId);
    /**
     *查询抢过红包的信息
     * @param toUserId ——用户Id
     * @return 影响记录数.
     */
   // PacketReceive getPacketReceive(int toUserId,int redPacketId);
}
