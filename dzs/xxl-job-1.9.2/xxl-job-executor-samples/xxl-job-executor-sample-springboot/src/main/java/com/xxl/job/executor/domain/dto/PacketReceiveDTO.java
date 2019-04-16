package com.xxl.job.executor.domain.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class PacketReceiveDTO {
    @ApiModelProperty("红包发送记录ID")
    private int redPacketId;
    @ApiModelProperty("发送方用户ID")
    private int fromUserId;
    @ApiModelProperty("领取方用户ID")
    private int toUserId;
    @ApiModelProperty("领取金额")
    private BigDecimal amount;
    @ApiModelProperty("领取时间")
    private Long createTime;

    public int getRedPacketId() {
        return redPacketId;
    }

    public void setRedPacketId(int redPacketId) {
        this.redPacketId = redPacketId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PacketReceiveDTO{" +
                "redPacketId=" + redPacketId +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", amount=" + amount +
                ", createTime=" + createTime +
                '}';
    }
}
