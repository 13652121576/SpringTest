package com.test;

import javafx.application.Application;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: SpringAop
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/10 15:39
 * @Version: 1.0
 */
@Aspect
@Component
public class SpringAop {

    @Pointcut(value = "execution(public * com.test.aopTest.*(..))")
    public void sayPointCut(){
    }

    @Before(value = "sayPointCut()")
    public void sayBeforeLog(){
        System.out.println("记录开始时间"+System.currentTimeMillis());
    }
    @After(value = "sayPointCut()")
    public void sayAfterLog(){
        System.out.println("记录结束时间"+System.currentTimeMillis());
    }

}
