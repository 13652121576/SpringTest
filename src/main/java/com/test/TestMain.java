package com.test;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: TestMain
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/11 9:32
 * @Version: 1.0
 */
public class TestMain {

    public static void main(String[] args){
        aopTest aopTest = new aopTestImpl();
        aopTest.say();
    }
}
