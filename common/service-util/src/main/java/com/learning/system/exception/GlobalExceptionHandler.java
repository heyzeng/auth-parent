package com.learning.system.exception;

import com.learning.common.reslut.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author:Jude
 * Date:2023-04-11 下午8:44
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // 1 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail().message("处理了全局异常");
    }

    // 2 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        System.out.println("处理了特定异常");
        e.printStackTrace();
        return Result.fail().message("处理了特定异常");
    }

    // 2 自定义异常处理
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result error(CustomException e) {
        System.out.println("处理了特定异常");
        e.printStackTrace();
        return Result.fail().message(e.getMessage()).code(e.getCode());
    }
}
