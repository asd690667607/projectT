package com.test.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.test.annotation.PermInfo;
import com.test.domain.orm.SysRole;
import com.test.domain.vo.Json;
import com.test.domain.vo.Option;
import com.test.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by CaiBaoHong at 2018/4/17 16:41<br>
 */
@PermInfo(value = "选项模块", pval = "a:option")
@RestController
@RequestMapping("/api/v1/option")
public class OptionController {

    private static final Logger log = LoggerFactory.getLogger(OptionController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/role")
    public Json listRoleOptions() {
        String oper = "list role options";
        log.info(oper);

        EntityWrapper<SysRole> params = new EntityWrapper<>();
        params.setSqlSelect("rid,rname,rval");

        List<SysRole> list = sysRoleService.selectList(params);
        List<Option> options = list.stream().map(obj -> new Option(obj.getRid(), obj.getRname(),obj.getRval())).collect(Collectors.toList());
        return Json.succ(oper, "options", options);
    }


}
