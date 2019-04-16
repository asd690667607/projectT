package com.test.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.dao.SysUserRoleMapper;
import com.test.domain.orm.SysUserRole;
import com.test.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
}
