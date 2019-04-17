package com.xxl.job.executor.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 *
 * @author dzs
 * @date 2019/3/27
 */
@ApiModel("用户")
public class WalletDTO {

    @ApiModelProperty("用户ID")
    private int userId;
    @ApiModelProperty("账户余额")
    private BigDecimal amount;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("修改时间")
    private Long updateTime;

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

    @Override
    public String toString() {
        return "WalletDTO{" +
                "userId=" + userId +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
