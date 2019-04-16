package com.xxl.job.executor.domain.orm;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 *
 * @author dzs
 * @date 2019/3/27
 */
public class Wallet implements Serializable {
    @ApiModelProperty("ID")
    private int id;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("账户余额")
    private BigDecimal amount;
    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("修改时间")
    private Long updateTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
        return "Wallet{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
