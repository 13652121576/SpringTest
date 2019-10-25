package com.HanderTest;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.xml.ws.Response;
import java.util.logging.Handler;
import java.util.logging.Level;

/**
 * @ProjectName: springmvc
 * @Package: com.HanderTest
 * @ClassName: Hander
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 10:20
 * @Version: 1.0
 */
interface BaseCase {
    // 所有 case 处理逻辑的方法
    void doSomething(String input, BaseCase baseCase);
}