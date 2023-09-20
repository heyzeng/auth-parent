package com.learning.system.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.learning.common.reslut.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
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
        Map<String, Object> loginMap = new HashMap<>();
        loginMap.put("token"," admin-token");
        return Result.ok(loginMap);
    }

    // 前端数据
    //        {
//            "code": 20000,
//                "data": {
//            "roles": [
//            "admin"
//        ],
//            "introduction": "I am a super administrator",
//                    "avatar": "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
//                    "name": "Super Admin"
//        }
//        }

    /**
     * 登录信息
     * @return
     */
    @GetMapping("/info")
    public Result info(){

        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("roles","[admin]");
        infoMap.put("introduction","I am a super administrator");
        infoMap.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        infoMap.put("name","Admin jude");
        return Result.ok(infoMap);
    }

//    {"code":20000,"data":"success"}

    @PostMapping("/logout")
    public Result logout() {

        return Result.ok();
    }

}
