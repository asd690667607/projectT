package com.test.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.dao.SysUserDao;
import com.test.dao.SysUserMapper;
import com.test.domain.orm.SysUser;
import com.test.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Page<SysUser> queryUserIncludeRoles(Page page, String nick) {
        return page.setRecords(baseMapper.selectUserIncludeRoles(page,nick));
    }

}

