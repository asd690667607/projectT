package com.xxl.job.executor.domain.orm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author dzs
 * @date 2019/3/27
 */
@ApiModel("区域")
public class Bill implements Serializable {

    @ApiModelProperty("主键 ID")
    private Integer id;
    @ApiModelProperty("用户ID")
    private Integer userId;
    @ApiModelProperty("可用变化量")
    private BigDecimal availableVariation;
    @ApiModelProperty("可用余额")
    private BigDecimal availableBalance;
    @ApiModelProperty("账单说明")
    private String  billExplain;
    @ApiModelProperty("钱包ID")
    private Integer walletId;
    @ApiModelProperty("业务ID")
    private String bizId;
    @ApiModelProperty("创建时间")
    private Long createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAvailableVariation() {
        return availableVariation;
    }

    public void setAvailableVariation(BigDecimal availableVariation) {
        this.availableVariation = availableVariation;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getBillExplain() {
        return billExplain;
    }

    public void setBillExplain(String billExplain) {
        this.billExplain = billExplain;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", userId=" + userId +
                ", availableVariation=" + availableVariation +
                ", availableBalance=" + availableBalance +
                ", billExplain='" + billExplain + '\'' +
                ", walletId=" + walletId +
                ", bizId='" + bizId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
