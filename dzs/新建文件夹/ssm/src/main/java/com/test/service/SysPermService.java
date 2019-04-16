package com.test.service;


import com.baomidou.mybatisplus.service.IService;
import com.test.domain.orm.SysPerm;
import com.test.domain.vo.AuthVo;

import java.util.List;
import java.util.Set;

public interface SysPermService extends IService<SysPerm> {

    Set<AuthVo> getPermsByUserId(String userId);

    List<SysPerm> getPermsByRoleId(String roleId);

    void saveOrUpdate(List<SysPerm> perms);



}
