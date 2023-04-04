package com.learning.common;

/**
 * Author:Jude
 * Date:2023-04-04 上午9:32
 */
public class GenericMethod {

    // 定义一个泛型方法，可以接受不同类型的参数，并返回相同类型的结果
    public static <T> T add(T x, T y) {
        // 根据不同的类型，执行不同的操作
        if (x instanceof Integer) {
            return (T) (Integer) ((Integer) x + (Integer) (y));
        } else if (x instanceof Double) {
            return (T) (Double) ((Double) x + (Double) y);
        } else if (x instanceof String) {
            return (T) (String) ((String) x + (String) y);
        } else {
            return null;
        }
    }

    //调用泛型方法，传入不同类型的参数
//    public static void main(String[] args) {
//        System.out.println(add(10, 10));
//        System.out.println(add(10.1, 20.2));
//        System.out.println(add("hello,"," world!"));
//    }
}
