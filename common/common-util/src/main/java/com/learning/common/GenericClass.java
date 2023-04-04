package com.learning.common;

/**
 * Author:Jude
 * Date:2023-04-04 上午10:06
 */
// 定义一个泛型类，可以存储任意类型的数据
public class GenericClass<T> {

    // 使用一个私有的泛型变量来保存数据
    private T value;

    // 构造方法，接受一个泛型参数
    public GenericClass(T value) {
        this.value = value;
    }

    //获取数据的方法，返回泛型类型
    public T getValue() {
        return value;
    }

    //设置数据的方法，接受一个泛型参数
    public void setValue(T value) {
        this.value = value;
    }
// 实例化泛型类，传入不同类型的参数
//    public static void main(String[] args) {
//
//        GenericClass<Integer> genericClass = new GenericClass<>(100);// 创建一个存储整数的数据对象
//        System.out.println(genericClass.getValue()); //100
//        genericClass.setValue(200);
//        System.out.println(genericClass.getValue());//200
//
//        GenericClass<String> hello = new GenericClass<>("hello");// 创建一个字符串的数据对象
//        System.out.println(hello.getValue());
//    }
}
