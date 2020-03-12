package com.Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: springmvc
 * @Package: com.Spring
 * @ClassName: ApplicationContext
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/20 8:59
 * @Version: 1.0
 */
public class ApplicationContext {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());
        context.getBean("");
    }

}
