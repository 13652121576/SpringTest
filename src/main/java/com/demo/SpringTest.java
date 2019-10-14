package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

/**
 * @ProjectName: springmvc
 * @Package: com.demo
 * @ClassName: SpringTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/29 10:15
 * @Version: 1.0
 */
public class SpringTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        Object o = context.getBean("person");
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(o.toString());

    }
}
