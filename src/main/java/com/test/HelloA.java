package com.test;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: HelloA
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 10:21
 * @Version: 1.0
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }

    {
        System.out.println("I'm A class");
    }
    static {
        System.out.println("static A");
    }


}
