package com.test.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.test.domain.orm.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectUserIncludeRoles(Pagination page, @Param("nick") String nick);

}
