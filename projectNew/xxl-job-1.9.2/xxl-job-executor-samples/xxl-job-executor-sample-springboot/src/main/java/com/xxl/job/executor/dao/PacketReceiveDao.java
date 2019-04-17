package com.xxl.job.executor.dao;

import com.xxl.job.executor.domain.orm.PacketReceive;
import com.xxl.job.executor.domain.orm.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PacketReceiveDao {
    /**
     * 插入抢红包信息.
     * @param PacketReceive ——抢红包信息
     * @return 影响记录数.
     */
    int grapRedPacket(PacketReceive packetReceive);
    /**
     *查询抢过红包的用户列表
     * @param redPacketId ——红包Id
     * @return 影响记录数.
     */
    List<User> getUserlist(int redPacketId);
    /**
     *查询抢过红包的信息
     * @param redPacketId ——用户Id
     * @return 影响记录数.
     */
    PacketReceive getPacketReceive(@Param("toUserId") int toUserId, @Param("redPacketId") int redPacketId);

}
