package com.test;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: Child
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 10:17
 * @Version: 1.0
 */
public class Child {
    People father;
    String name;
    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);
    }
}
