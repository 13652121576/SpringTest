package com.CurrentLimiting;

/**
 * @ProjectName: springmvc
 * @Package: com.CurrentLimiting
 * @ClassName: LeakyBucket
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 9:20
 * @Version: 1.0
 */
public class LeakyBucket {
    public static long timeStamp = getNowTime();
    public static int capacity = 500; // 桶的容量
    public static int rate = 10; // 水漏出的速度
    public static Long water = 0L; // 当前水量(当前累积请求数)
    public static boolean grant() {
        long now = getNowTime();
        water = Math.max(0L, water - (now - timeStamp) * rate); // 先执行漏水，计算剩余水量
        timeStamp = now;
        if ((water + 1) < capacity) {
            // 尝试加水,并且水还未满
            water += 1;
            return true;
        }
        else {
            // 水满，拒绝加水
            return false;
        }
    }
    private static Long getNowTime(){
        return System.currentTimeMillis();
    }
    public static void main(String[] args){
        for(int i=1;i<1000;i++){
            System.out.println(grant());
        }
    }
}
