package com.learning.system.test;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learning.model.system.SysRole;
import com.learning.system.mapper.SysRoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
    // 1 查看所有数据
    @Test
    public void findAll() {
        log.info("select all");
        List<SysRole> user = sysRoleMapper.selectList(null);
        for (SysRole sysRole : user) {
            log.info("sysRole", sysRole);
        }
    }

    // 2 插入数据
    @Test
    public void testInsert() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("test1");
        sysRole.setRoleCode("test1");
        sysRole.setDescription("test1");
        int insert = sysRoleMapper.insert(sysRole);
        log.info("insert", insert);
    }

    // 3 更新
    @Test
    public void testUpdate() {
        //查找id
        SysRole sysRole = sysRoleMapper.selectById(8);
        //修改数据
//        sysRole.setDescription("2023.3.31");
        sysRole.setRoleCode("test");
        //调用方法进行修改
        sysRoleMapper.updateById(sysRole);
    }

    // 4 id删除
    @Test
    public void testIdDelete() {
        int deleteById = sysRoleMapper.deleteById(10);
    }

    // 5 批量删除
    @Test
    public void testBatchDelete() {
        sysRoleMapper.deleteBatchIds(Arrays.asList(10, 11, 12));
    }

    // 6 条件查找
    @Test
    public void testConditionSelect() {

        //QueryWrapper是MyBatis Plus中的一个条件构造器，用于封装查询条件，生成SQL的where语句12。
        // 它继承自AbstractWrapper，可以通过new QueryWrapper().lambda()方法获取LambdaQueryWrapper3
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.eq("role_code", "test");//设置等于查询条件
        List<SysRole> sysRoles = sysRoleMapper.selectList(sysRoleQueryWrapper);//调用mapper接口的selectList方法，传入sysRoleQueryWrapper对象
        log.info("s", sysRoles);
    }

    // 7 条件删除
    @Test
    public void testConditionDelete() {

        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_code", "COMMON");
        sysRoleMapper.delete(queryWrapper);

    }
}
