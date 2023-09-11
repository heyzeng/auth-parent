package com.learning.system.controller;

import com.learning.common.reslut.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:Jude
 * Date:2023-09-11 23:48
 */

@Api(tags = "后台管理系统")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public Result login(){

//        {"code":20000,"data":{"token":"admin-token"}}
        Map<String, String> loginMap = new HashMap<>();
        loginMap.put("token"," admin-token");
        return Result.ok(loginMap);
    }

}
