package com.learning.system.controller;

import com.learning.common.reslut.Result;
import com.learning.model.system.SysRole;
import com.learning.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:Jude
 * Date:2023-04-03 上午11:54
 */

// 3 条件分页查询


// 2 逻辑删除接口

// 1 查询所有记录
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("/findAll")
    protected Result<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
//        return roleList;
        return Result.ok(roleList);
    }
}
