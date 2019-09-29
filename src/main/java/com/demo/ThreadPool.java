package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: springmvc
 * @Package: com.demo
 * @ClassName: ThreadPool
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/24 15:31
 * @Version: 1.0
 */
public class ThreadPool {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(20);
    }
}
