package com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springmvc
 * @Package: com.event
 * @ClassName: EatListener
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/17 10:37
 * @Version: 1.0
 */
@Component
public class EatListener implements ApplicationListener<EatEvent> {

    @Override
    public void onApplicationEvent(EatEvent eatEvent) {
        System.out.println("监听到他们正zai吃"+eatEvent.getSomeThing());
    }
}
