package com.learning.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learning.model.system.SysRole;
import org.springframework.stereotype.Repository;


/**
 * Author:Jude
 * Date:2023-03-30 下午3:43
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole>{//SysRole需要引入model依赖

}
