package com.xxl.job.executor.service.impl;
import com.xxl.job.executor.dao.PacketReceiveDao;
import com.xxl.job.executor.dao.PacketSendDao;
import com.xxl.job.executor.domain.orm.*;
import com.xxl.job.executor.service.IPacketReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
public class PacketReceiveServiceImpl implements IPacketReceiveService {
    /**
     * 保存抢红包信息.
     *
     * @param redPacketId 红包编号
     * @param toUserId    抢红包用户编号
     * @return 影响记录数.
     */
    @Autowired
    private PacketReceiveDao packetReceiveDao;
    @Autowired
    private PacketSendDao packetSendDao;
    @Autowired
    private RedisTemplate redisTemplate;
    // 失败
    private static final int FAILED = 0;

    /**
     *
     *
     * @Title: grapRedPacketForVersion
     *
     * @Description: 乐观锁，按次数重入
     *
     * @param redPacketId
     * @param userId
     *
     * @return: int
     */

    @Override
    @Transactional(rollbackFor={SQLException.class},isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int grapRedPacketForVersion(int redPacketId, int toUserId) {
        // 获取红包信息，注意version值
     PacketSend packetSend = packetSendDao.getRedPacket(redPacketId);
     int redPacketType  = packetSend.getRedPacketType();
     int fromUserId= packetSend.getUserId();
     int stock =packetSend.getStock();
            if (stock> 0) {
                // 再次传入线程保存的version旧值给SQL判断，是否有其他线程修改过数据
                int update = packetSendDao.decreaseRedPacketForVersion(redPacketId);
                // 如果没有数据更新，则说明其他线程已经修改过数据，则重新抢夺
                if (update == 0) {
                   throw  new RuntimeException("抢红包失败");
                }
                // 生成抢红包信息
                PacketReceive userRedPacket = new PacketReceive();
                userRedPacket.setRedPacketId(redPacketId);
                userRedPacket.setToUserId(toUserId);
                userRedPacket.setFromUserId(fromUserId) ;
                BigDecimal newAmount = new BigDecimal("0");
                if (redPacketType ==2)
                {
                    newAmount= packetSend.getAmount();
                    userRedPacket.setAmount(newAmount);
                }
                if(redPacketType ==1){
                    //从缓存中取出红包金额
                    String listValue ="0";
                    if(redPacketType ==1) {
                        listValue = redisTemplate.opsForList().rightPop("list"+packetSend.getId()) + "";
                        System.out.println("11111111111111"+listValue);
                    }
                    newAmount = new BigDecimal(listValue);

                    userRedPacket.setAmount(newAmount);
                }

                // 插入抢红包信息
                int result = packetReceiveDao.grapRedPacket(userRedPacket);
                if (result <= 0) {
                    throw new RuntimeException();
                }
                //新建账单
                Bill bill = new Bill();
                bill.setUserId(toUserId);
                //获取用户钱包
                Wallet wallet = packetSendDao.getWallet(toUserId);
                //获取用户余额
                BigDecimal amount= wallet.getAmount();
                //更新钱包余额
                wallet.setAmount(amount.add(newAmount));
               int r= packetSendDao.updateWallet(wallet);
                if(r<=0){
                    throw  new RuntimeException("Error");
                }
                //记录领取红包账单
                bill.setAvailableBalance(wallet.getAmount());
                bill.setAvailableVariation(newAmount);
                bill.setBillExplain("领取红包");
                bill.setWalletId(wallet.getId());
                int re= packetSendDao.insertBill(bill);
                if ( re <=0) {
                   throw new RuntimeException();
               }
                if(stock ==1)
                {
                    int id = packetSend.getId();
                    int redPacketStatus = 3;
                    int res=packetSendDao.updateRedPacket(id,redPacketStatus);
                    if(res<=0){
                        throw new RuntimeException();
                    }
                }
                return result;
            } else {
                return FAILED;
            }
    }

    /**
     * 查询抢过红包的用户列表
     *
     * @param redPacketId ——红包Id
     * @return 影响记录数.
     */
    @Override
    public List<User> getUserlist(int redPacketId) {
        return packetReceiveDao.getUserlist(redPacketId);
    }
    /**
     * 查询抢过红包的信息
     *
     * @param toUserId ——用户Id
     * @return 影响记录数.
     */
    @Override
    public PacketReceive getPacketReceive(int toUserId,int redPacketId) {
        return packetReceiveDao.getPacketReceive(toUserId,redPacketId);
    }
}