package com.test.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.dao.SysRolePermMapper;
import com.test.domain.orm.SysRolePerm;
import com.test.service.SysRolePermService;
import org.springframework.stereotype.Service;

@Service
public class SysRolePermServiceImpl extends ServiceImpl<SysRolePermMapper, SysRolePerm> implements SysRolePermService {
}
