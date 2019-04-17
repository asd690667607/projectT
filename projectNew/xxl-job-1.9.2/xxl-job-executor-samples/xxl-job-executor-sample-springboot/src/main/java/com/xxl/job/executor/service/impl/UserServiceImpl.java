package com.xxl.job.executor.service.impl;

import com.xxl.job.executor.dao.UserDao;

import com.xxl.job.executor.domain.orm.User;
import com.xxl.job.executor.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by dzs on 2019/3/7
 */
@Service
public class UserServiceImpl implements IUserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserDao userDao;
    /**
     * 列出用户列表
     *
     * @return 用户列表
     */
    @Override
    public List<User> getUserList() {
        return userDao.queryUser();
    }
    /**
     * 根据nickName列出具体用户
     *
     * @param  用户名 nickName
     * @return 管理员
     */
    @Override
    public User getUserByNickName(String nickName) {
        return userDao.queryUserByNickName(nickName);
    }
    /**
     * 根据Id列出具体管理员
     *
     * @param id id
     * @return 管理员
     */
    @Override
    public User getUserById(int id) {
        return userDao.queryUserById(id);
    }

}
