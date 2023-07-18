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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:Jude
 * Date:2023-04-03 上午11:54
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    // 1 查询所有记录
    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("findAll")
    protected Result<List<SysRole>> findAll() {
        List<SysRole> roleList = sysRoleService.list();
//        return roleList;
        //测试自定义异常
//        try {
//            int a = 10 / 0;
//        } catch (Exception e) {
//            throw new CustomException(20001,"自定义异常");
//        }

        return Result.ok(roleList);
    }

    // 2 逻辑删除接口
    @ApiOperation(value = "逻辑删除接口")
    @GetMapping("remove/{id}")
    protected Result<List<SysRole>> removeRole(@PathVariable Integer id) {
        //调用方法删除
        boolean isSuccessRemove = sysRoleService.removeById(id);
        if (isSuccessRemove) {
            return Result.ok();
        }
        {
            return Result.fail();
        }
    }

    // 3 条件分页查询
    // page当前页数，limit每页显示数
    @ApiOperation(value = "分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysRoleQueryVo sysRoleQueryVo) {
        //1 创建page对象
        Page<SysRole> pageParam = new Page<>(page, limit);
        //2 调用service方法
        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam, sysRoleQueryVo);
        //3 返回
        return Result.ok(pageModel);
    }

    //4 添加角色
    @ApiOperation(value = "添加角色")
    @GetMapping("save")
    protected Result<List<SysRole>> saveRole(SysRole sysRole) {

        boolean saveRole = sysRoleService.save(sysRole);
        if (saveRole) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 5 根据id查找
    @ApiOperation(value = "根据id查找")
    @GetMapping("find/{id}")
    protected Result findById(@PathVariable Integer id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    // 6 最终修改
    @ApiOperation(value = "最终修改")
    @GetMapping("update")
    public Result update(SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 7 批量删除
    @ApiOperation(value = "批量删除接口")
    @DeleteMapping("batchRemove")
    protected Result batchRemove(@RequestBody List<Integer> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }

    // 8 获取用户的角色数据
    @ApiOperation(value = "获取用户的角色数据")
    @GetMapping("toAssign/{userId}")
    protected Result toAssign(@PathVariable String userId){

        return null;
    }
}
