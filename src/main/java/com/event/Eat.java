package com.event;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: springmvc
 * @Package: com.event
 * @ClassName: Eat
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/17 10:28
 * @Version: 1.0
 */

@RestController
public class Eat {

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/eat/{sth}")
    public String eat(@PathVariable(value = "sth") String sth){
        System.out.println("吃饭ing...");
        EatEvent eatEvent = new EatEvent(applicationContext, sth);
        applicationContext.publishEvent(eatEvent);
        return "吃完了";
    }
}
