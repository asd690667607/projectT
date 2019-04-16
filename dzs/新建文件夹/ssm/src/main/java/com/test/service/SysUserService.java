package com.test.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.test.domain.orm.SysUser;

public interface SysUserService extends IService<SysUser> {

    Page<SysUser> queryUserIncludeRoles(Page page, String nick);

}
