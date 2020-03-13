package com.test;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: People
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 10:16
 * @Version: 1.0
 */
public class People {
    String name;
    public People() {
        System.out.print(1);
    }
    public People(String name) {
        System.out.print(2); this.name = name;
    }
}
