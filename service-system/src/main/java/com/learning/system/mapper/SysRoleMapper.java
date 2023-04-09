package com.learning.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learning.model.system.SysRole;
import com.learning.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * Author:Jude
 * Date:2023-03-30 下午3:43
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {//SysRole需要引入model依赖

    // 条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
