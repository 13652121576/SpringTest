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
    public static void main(String[] args) throws InterruptedException {

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 2");
            }
        }, "T2");
        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " run 3");
            }
        }, "T3");


//        method 2 使用 单个任务的线程池来实现。保证线程的依次执行
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t3);
        executor.submit(t1);
        executor.submit(t2);

        executor.shutdown();
    }


}
