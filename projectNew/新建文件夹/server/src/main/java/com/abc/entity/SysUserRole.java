package com.abc.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * created by dzs at 2019/3/12 11:07<br>
 */
@TableName("sys_user_role")
public class SysUserRole implements Serializable {

    @TableField("user_id")
    @ApiModelProperty("用户Id")
    private String userId;
    @TableField("role_id")
    @ApiModelProperty("角色Id")
    private String roleId;

    public SysUserRole() {
    }

    public SysUserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
