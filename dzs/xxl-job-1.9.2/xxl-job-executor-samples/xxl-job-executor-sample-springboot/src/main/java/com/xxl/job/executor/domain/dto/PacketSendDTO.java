package com.xxl.job.executor.domain.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 *
 * @author dzs
 * @date 2019/3/27
 */
public class PacketSendDTO {
    @ApiModelProperty("个人用户ID")
    private int userId;
    @ApiModelProperty("红包发送金额")
    private BigDecimal amount;
    @ApiModelProperty("红包发送数量")
    private int redPacketCount;
    @ApiModelProperty("已领取的红包金额")
    private BigDecimal receiveAmount;
    @ApiModelProperty("群ID")
    private int groupId;
    @ApiModelProperty("剩余红包个数")
    private int stock;
    @ApiModelProperty("红包类型")
    private int redPacketType;
    @ApiModelProperty("红包状态")
    private int redPacketStatus;
    @ApiModelProperty("红包发送时间")
    private Long createTime;
    @ApiModelProperty("修改时间")
    private Long updateTime;
    @ApiModelProperty("版本")
    private Integer version;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getRedPacketCount() {
        return redPacketCount;
    }

    public void setRedPacketCount(int redPacketCount) {
        this.redPacketCount = redPacketCount;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRedPacketType() {
        return redPacketType;
    }

    public void setRedPacketType(int redPacketType) {
        this.redPacketType = redPacketType;
    }

    public int getRedPacketStatus() {
        return redPacketStatus;
    }

    public void setRedPacketStatus(int redPacketStatus) {
        this.redPacketStatus = redPacketStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PacketSendDTO{" +
                "userId=" + userId +
                ", amount=" + amount +
                ", redPacketCount=" + redPacketCount +
                ", receiveAmount=" + receiveAmount +
                ", groupId=" + groupId +
                ", stock=" + stock +
                ", redPacketType=" + redPacketType +
                ", redPacketStatus=" + redPacketStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}
