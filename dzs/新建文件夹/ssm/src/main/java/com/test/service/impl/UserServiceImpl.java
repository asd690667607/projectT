package com.test.service.impl;

import com.test.dao.SysUserDao;
import com.test.domain.orm.SysUser;
import com.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SysUserDao userDao;

    @Override
    public SysUser selectUserByUname(String uname) {
        return userDao.selectUserByUname(uname);
    }
}
