package com.abc.dao;

import com.abc.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 查找用户
     *
     * @param nick 昵称  page 页面
     * @return 影响行
     */
    List<SysUser> selectUserIncludeRoles(Pagination page, @Param("nick")String nick);

}
