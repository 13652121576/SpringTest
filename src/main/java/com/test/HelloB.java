package com.test;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: HelloB
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 10:23
 * @Version: 1.0
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }

    {
        System.out.println("I'm B class");
    }
    static {
        System.out.println("static B");
    }
}
