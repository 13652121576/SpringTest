package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: springmvc
 * @Package: com.test
 * @ClassName: controller
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/11 9:53
 * @Version: 1.0
 */
@RequestMapping
@Controller
public class controller {

    @Autowired
    aopTest aopTest;
    @RequestMapping("/hi")
    @ResponseBody
    public String say(){
        System.out.println("welcome");
        aopTest.say();
        return "index";
    }
}
