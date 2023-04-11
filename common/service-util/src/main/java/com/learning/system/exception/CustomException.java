package com.learning.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:Jude
 * Date:2023-04-11 下午9:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private Integer code;
    private String message;
}
