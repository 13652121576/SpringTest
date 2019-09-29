package com.test;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: aopTestImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/10 15:40
 * @Version: 1.0
 */
@Component
public class aopTestImpl implements aopTest {
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
