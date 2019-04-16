package com.test.service;

import com.test.domain.orm.SysUser;

public interface UserService {
    SysUser selectUserByUname(String uname);
}
