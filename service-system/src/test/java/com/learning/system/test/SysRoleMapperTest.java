package com.learning.system.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.learning.model.system.SysRole;
import com.learning.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Author:Jude
 * Date:2023-03-30 下午3:59
 */

@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    //日志
    Log log = LogFactory.get();


    //IDEA在sysRoleMapper处报错，因为找不到注入的对象，因为类是动态创建的，但是程序可以正确的执行。
    //为了避免报错，可以在 mapper 层 的接口上添加 @Repository 或直接使用 @Resource 代替 @Autowired。
    //创建com.xxx.xxx.test
    //bug:java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration,
    // you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
    @Test
    public void findAll(){
        log.info("select all");
        List<SysRole> user = sysRoleMapper.selectList(null);
        for (SysRole sysRole: user) {
            log.info("sysRole",sysRole);
        }

    }
}
