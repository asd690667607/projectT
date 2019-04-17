package com.abc.dao;

import com.abc.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查找角色
     *
     * @param userId 用户Id
     * @return 影响行
     */
    List<SysRole> getRolesByUserId(@Param("userId") String userId);
    /**
     * 查找角色Id
     *
     * @param userId 用户Id
     * @return 影响行
     */
    List<String> getRoleIdsByUserId(@Param("userId") String userId);
    /**
     * 检查角色Id角色值
     *
     * @param rids 角色Id  rval 角色值
     * @return 影响行
     */
    Boolean checkRidsContainRval(@Param("rids")List<String> rids,@Param("rval")String rval);
    /**
     * 检查用户Id角色值
     *
     * @param uid 用户Id  rval 角色值
     * @return 影响行
     */
    Boolean checkUidContainRval(@Param("uid")String uid,@Param("rval")String rval);

}
