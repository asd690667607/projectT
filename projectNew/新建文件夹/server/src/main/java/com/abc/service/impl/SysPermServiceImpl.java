package com.abc.service.impl;

import com.abc.dao.SysPermMapper;
import com.abc.entity.SysPerm;
import com.abc.service.SysPermService;
import com.abc.vo.AuthVo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * @author dzs
 * @date 16:04 2019/3/14
 */
@Service
public class SysPermServiceImpl extends ServiceImpl<SysPermMapper, SysPerm> implements SysPermService {
    /**
     * 根据userId得到角色权限
     *
     * @param userId 用户Id
     * @return 影响行
     */
    @Override
    public Set<AuthVo> getPermsByUserId(String userId) {
        List<SysPerm> list = baseMapper.getPermsByUserId(userId);
        return list.stream().map(p->new AuthVo(p.getPname(),p.getPval())).collect(Collectors.toSet());
    }
    /**
     * 根据roleId得到角色权限
     *
     * @param roleId 角色Id
     * @return 影响行
     */
    @Override
    public List<SysPerm> getPermsByRoleId(String roleId) {
        return baseMapper.getPermsByRoleId(roleId);
    }
    /**
     * 增加更新菜单
     *
     * @param perms 角色权限
     * @return 影响行
     */
    @Override
    public void saveOrUpdate(List<SysPerm> perms) {
        if (perms!=null&&!perms.isEmpty()){
            baseMapper.saveOrUpdate(perms);
        }
    }


}
