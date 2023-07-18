package com.learning.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.model.system.SysRole;
import com.learning.model.vo.SysRoleQueryVo;

/**
 * Author:Jude
 * Date:2023-04-03 上午9:29
 */
public interface SysRoleService extends IService<SysRole> {

    //条件分类查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);

}
