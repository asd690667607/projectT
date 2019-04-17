package com.abc.service;

import com.abc.entity.SysUser;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
/**
 * @author dzs
 * @date 15:30 2019/3/14
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 查询所有系统用户
     *
     * @param page 页数，nick 昵称
     * @return 影响行
     */
    Page<SysUser> queryUserIncludeRoles(Page page, String nick);

}
