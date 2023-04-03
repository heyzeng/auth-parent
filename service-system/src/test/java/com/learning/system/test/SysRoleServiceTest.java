package com.learning.system.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learning.model.system.SysRole;
import com.learning.system.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * Author:Jude
 * Date:2023-04-03 上午10:36
 */
@SpringBootTest
public class SysRoleServiceTest {

    @Autowired
    private SysRoleService sysRoleService;

    //日志
    Log log =  LogFactory.get();

    @Test
    public void findAll() {

        log.info("=====findAll=====");
        List<SysRole> list = sysRoleService.list();
        for (SysRole sysRole: list) {
            log.info("list",sysRole);
        }
    }

    @Test
    public void testInsert() {

        log.info("=======");
        SysRole sysRole = new SysRole();
        sysRole.setRoleCode("one");
        sysRole.setDescription("one");
        sysRole.setRoleName("one");

        boolean b = sysRoleService.save(sysRole);
        log.info("testResult",b);
    }

    @Test
    public void testUpdate() {
        SysRole byId = sysRoleService.getById(16);
        byId.setRoleName("two");
        sysRoleService.updateById(byId);
    }

    @Test
    public void testIdDelete() {
        boolean b = sysRoleService.removeById(17);
    }

    @Test
    public void  testBatchDelete(){
        boolean b = sysRoleService.removeByIds(Arrays.asList(1, 2));
    }

    @Test
    public void testConditionFind() {

        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.eq("role_name","two");

        List<SysRole> testConditionFind = sysRoleService.list(sysRoleQueryWrapper);
        log.info("testConditionFind",testConditionFind);
    }

    @Test
    public void testConditionDelete() {

        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.eq("role_name","two");

        sysRoleService.remove(sysRoleQueryWrapper);
    }


}
