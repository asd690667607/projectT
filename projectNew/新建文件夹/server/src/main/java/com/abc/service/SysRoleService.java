package com.abc.service;

import com.abc.entity.SysRole;
import com.abc.vo.AuthVo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;
/**
 * @author dzs
 * @date 15:20 2019/3/14
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据userId得到角色
     *
     * @param userId 用户Id
     * @return 影响行
     */
    Set<AuthVo> getRolesByUserId(String userId);
    /**
     * 根据userId得到角色Id
     *
     * @param userId 用户Id
     * @return 影响行
     */
    List<String> getRoleIdsByUserId(String userId);
    /**
     * 检查用户角色 不能给非管理员用户赋予管理员角色
     *
     * @param rids 角色Id ，rval  rval
     * @return 影响行
     */
    boolean checkRidsContainRval(List<String> rids, String rval);
    /**
     * 检查用户角色 不能删除管理员用户
     *
     * @param uid 用户Id ，rval  rval
     * @return 影响行
     */
    boolean checkUidContainRval(String uid, String rval);

}
