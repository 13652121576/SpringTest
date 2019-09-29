package com.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springmvc
 * @Package: com.event
 * @ClassName: EatEvent
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/17 10:27
 * @Version: 1.0
 */
public class EatEvent extends ApplicationContextEvent {

    private String someThing;


    public EatEvent(ApplicationContext source, String someThing) {
        super(source);
        this.someThing = someThing;
    }

    public String getSomeThing() {
        return someThing;
    }

    public void setSomeThing(String someThing) {
        this.someThing = someThing;
    }
}
