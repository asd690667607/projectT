package com.abc.service;

import com.abc.entity.SysPerm;
import com.abc.vo.AuthVo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Set;
/**
 * @author dzs
 * @date 15:20 2019/3/14
 */
public interface SysPermService extends IService<SysPerm> {
    /**
     * 根据userId得到角色权限
     *
     * @param userId 用户Id
     * @return 影响行
     */
    Set<AuthVo> getPermsByUserId(String userId);
    /**
     * 根据roleId得到角色权限
     *
     * @param roleId 角色Id
     * @return 影响行
     */
    List<SysPerm> getPermsByRoleId(String roleId);
    /**
     * 增加更新菜单
     *
     * @param perms 角色权限
     * @return 影响行
     */
    void saveOrUpdate(List<SysPerm> perms);



}
