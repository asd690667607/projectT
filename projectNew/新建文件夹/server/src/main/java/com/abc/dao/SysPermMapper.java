package com.abc.dao;

import com.abc.entity.SysPerm;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysPermMapper extends BaseMapper<SysPerm> {
    /**
     * 查找用户权限
     *
     * @param userId 用户Id
     * @return 影响行
     */
    List<SysPerm> getPermsByUserId(@Param("userId") String userId);
    /**
     * 查找角色权限
     *
     * @param roleId 角色
     * @return 影响行
     */
    List<SysPerm> getPermsByRoleId(@Param("roleId") String roleId);
    /**
     * 增加更新权限
     *
     * @param perms 权限
     * @return 影响行
     */
    void saveOrUpdate(@Param("perms") List<SysPerm> perms);



}
