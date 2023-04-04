package com.learning.common.reslut;

import lombok.Data;
import lombok.val;

/**
 * Author:Jude
 * Date:2023-04-04 上午9:14
 */

@Data
public class Result<T> {

    //返回码
    private Integer code;

    //返回消息
    private String message;

    //返回数据
    private T data;

    public Result() {
    }

    // 返回数据
    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }




}
