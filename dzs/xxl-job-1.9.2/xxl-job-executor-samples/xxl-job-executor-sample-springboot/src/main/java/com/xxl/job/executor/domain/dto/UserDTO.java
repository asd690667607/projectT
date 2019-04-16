package com.xxl.job.executor.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author dzs
 * @date 2019/3/27
 */
@ApiModel("用户")
public class UserDTO {

    @ApiModelProperty("支付密码")
    private String payPass;
    @ApiModelProperty("盐")
    private String paySalt;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("修改时间")
    private Long updateTime;

    public String getPayPass() {
        return payPass;
    }

    public void setPayPass(String payPass) {
        this.payPass = payPass;
    }

    public String getPaySalt() {
        return paySalt;
    }

    public void setPaySalt(String paySalt) {
        this.paySalt = paySalt;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "payPass='" + payPass + '\'' +
                ", paySalt='" + paySalt + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
