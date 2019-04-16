package com.test.dao;

import com.test.domain.orm.SysUser;

public interface SysUserDao {
    SysUser selectUserByUname(String uname);
}
