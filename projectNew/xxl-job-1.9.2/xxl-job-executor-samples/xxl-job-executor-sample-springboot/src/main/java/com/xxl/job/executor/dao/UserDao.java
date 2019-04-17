package com.xxl.job.executor.dao;


import com.xxl.job.executor.domain.orm.User;

import java.util.List;

/**
 * @author dingzhaoshuang
 * @date 17:33 2019/3/7
 */
public interface UserDao {
    /**
     * 列出用户列表
     *
     * @return 用户列表
     */
    List<User> queryUser();

    /**
     * 根据nickName列出具体管理员
     *
     * @param id id
     * @return 管理员
     */
    User queryUserByNickName(String nickName);
    /**
     * 根据Id列出具体管理员
     *
     * @param id id
     * @return 管理员
     */
    User queryUserById(int id);


}
