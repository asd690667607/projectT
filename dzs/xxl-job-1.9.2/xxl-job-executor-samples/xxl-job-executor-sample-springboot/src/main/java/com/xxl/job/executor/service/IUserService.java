package com.xxl.job.executor.service;


import com.xxl.job.executor.domain.orm.User;

import java.util.List;

/**
 * 用户操作
 *
 * @author dingzhaoshuang
 * @date 17:36 2019/3/7
 */
public interface IUserService {
    /**
     * 列出管理员列表
     *
     * @return 管理员列表
     */
    List<User> getUserList();

    /**
     * 根据Id列出具体管理员
     *
     * @param id id
     * @return 管理员
     */
    User getUserById(int id);
    /**
     * 根据nickName列出具体管理员
     *
     * @param 用户名 nickName
     * @return 管理员
     */
    User getUserByNickName(String nickName);


}
