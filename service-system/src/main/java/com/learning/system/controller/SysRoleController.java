package com.learning.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.common.reslut.Result;
import com.learning.model.system.SysRole;
import com.learning.model.vo.SysRoleQueryVo;
import com.learning.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:Jude
 * Date:2023-04-03 上午11:54
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // 3 条件分页查询
    // page当前页数，limit每页显示数
    @ApiOperation(value = "分页查询")
    @GetMapping("/{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo) {
        //1 创建page对象
        Page<SysRole> pageParam = new Page<>(page,limit);
        //2 调用service方法
        IPage<SysRole> pageModel =  sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        //3 返回
        return Result.ok(pageModel);
    }

    // 2 逻辑删除接口


    // 1 查询所有记录
    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("/findAll")
    protected Result<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
//        return roleList;
        return Result.ok(roleList);
    }
}
