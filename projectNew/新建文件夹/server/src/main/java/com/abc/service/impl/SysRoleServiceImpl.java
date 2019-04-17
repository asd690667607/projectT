package com.abc.service.impl;

import com.abc.dao.SysRoleMapper;
import com.abc.entity.SysRole;
import com.abc.service.SysRoleService;
import com.abc.vo.AuthVo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * @author dzs
 * @date 15:45 2019/3/14
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    /**
     * 根据userId得到角色
     *
     * @param userId 用户Id
     * @return 影响行
     */
    @Override
    public Set<AuthVo> getRolesByUserId(String userId) {
        List<SysRole> list = baseMapper.getRolesByUserId(userId);
        return list.stream().map(r->new AuthVo(r.getRname(),r.getRval())).collect(Collectors.toSet());
    }
    /**
     * 根据userId得到角色Id
     *
     * @param userId 用户Id
     * @return 影响行
     */
    @Override
    public List<String> getRoleIdsByUserId(String userId) {
        return baseMapper.getRoleIdsByUserId(userId);
    }
    /**
     * 检查用户角色 不能给非管理员用户赋予管理员角色
     *
     * @param rids 角色Id ，rval  rval
     * @return 影响行
     */
    @Override
    public boolean checkRidsContainRval(List<String> rids, String rval) {
        if (rids.isEmpty()) return false;
        Boolean re = baseMapper.checkRidsContainRval(rids, rval);
        return re==null?false:re.booleanValue();
    }
    /**
     * 检查用户角色 不能删除管理员用户
     *
     * @param uid 用户Id ，rval  rval
     * @return 影响行
     */
    @Override
    public boolean checkUidContainRval(String uid, String rval) {
        if (StringUtils.isBlank(uid)) return false;
        Boolean re = baseMapper.checkUidContainRval(uid, rval);
        return re==null?false:re.booleanValue();
    }
}
