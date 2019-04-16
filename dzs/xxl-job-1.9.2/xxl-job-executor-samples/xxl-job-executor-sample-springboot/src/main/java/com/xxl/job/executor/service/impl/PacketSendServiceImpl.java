package com.xxl.job.executor.service.impl;
import com.xxl.job.executor.dao.PacketSendDao;
import com.xxl.job.executor.domain.orm.Bill;
import com.xxl.job.executor.domain.orm.PacketSend;
import com.xxl.job.executor.domain.orm.Wallet;
import com.xxl.job.executor.service.IPacketSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;

@Component
@Service
public class PacketSendServiceImpl implements IPacketSendService {
    @Autowired
    private PacketSendDao packetSendDao;
    @Override
    public PacketSend getRedPacket(int id) {
        return packetSendDao.getRedPacket(id);
    }
    /**
     * 发红包
     *
     * @param packetSend ——红包
     * @return 影响条数.
     */
    @Override
    @Transactional(rollbackFor={SQLException.class},isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertPacket(PacketSend packetSend) {
        int result = packetSendDao.insertPacket(packetSend);
        if(result<=0){
            throw  new RuntimeException("Error");
        }
        int userId = packetSend.getUserId();
        BigDecimal amount = packetSend.getAmount();
        int count = packetSend.getRedPacketCount();
        int redPacketType = packetSend.getRedPacketType();
        Wallet wallet =packetSendDao.getWallet(userId);
        //获取钱包余额
        BigDecimal availableBalance= wallet.getAmount();
        //初始化余额
        BigDecimal  newAvailableBalance = new BigDecimal("0");
        BigDecimal newCount = new BigDecimal(count);
        //类型为普通红包
        if(redPacketType ==2) {
            BigDecimal  amountAll =amount.multiply(newCount);
            newAvailableBalance = availableBalance.subtract(amountAll);
        }
        //类型为运气红包
        if(redPacketType ==1) {
            newAvailableBalance = availableBalance.subtract(amount);

        }
        BigDecimal bleBalance = availableBalance.subtract(newAvailableBalance);
        //更新钱包余额
        wallet.setAmount(newAvailableBalance);
      int res=  packetSendDao.updateWallet(wallet);
        if(res<=0){
            throw  new RuntimeException("Error");
        }
        //插入发红包信息
        //新建一个账单
        Bill bill = new Bill();
        bill.setUserId(userId);
        bill.setAvailableBalance(newAvailableBalance);
        bill.setAvailableVariation(bleBalance);
        bill.setBillExplain("发送红包");
        bill.setWalletId(wallet.getId());
        //记录账单
       int re= packetSendDao.insertBill(bill);
       if(re<=0){
           throw  new RuntimeException("Error");
       }
        return result;
    }

    /**
     * 查询钱包
     *
     * @param Wallet@return 更新记录条数
     */
    @Override
    public Wallet getWallet(int userId) {
        return packetSendDao.getWallet(userId);
    }


}
