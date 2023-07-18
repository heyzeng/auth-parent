package com.learning.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.model.system.SysRole;
import com.learning.model.vo.SysRoleQueryVo;
import com.learning.system.mapper.SysRoleMapper;
import com.learning.system.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * Author:Jude
 * Date:2023-04-03 上午9:34
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
        IPage<SysRole> pageModel = baseMapper.selectPage(pageParam, sysRoleQueryVo);
        return pageModel;
    }

    //获取用户的角色数据

    // 用户分配角色
}
