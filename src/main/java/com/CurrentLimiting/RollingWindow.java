package com.CurrentLimiting;

/**
 * @ProjectName: springmvc
 * @Package: com.CurrentLimiting
 * @ClassName: RollingWindow
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/11 15:11
 * @Version: 1.0
 */
public class RollingWindow {

    public static long timeStamp = getNowTime();
    public static int reqCount = 0;
    public static final int limit = 100; // 时间窗口内最大请求数
    public static final long interval = 6000; // 时间窗口6ms,6格

    public static boolean grant() {
        long now = getNowTime();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }

    private static Long getNowTime() {
        return System.currentTimeMillis();
    }
    public static void main(String[] args) {
//        for(int i=1;i<1000;i++){
//            System.out.println(grant());
//        }
        System.out.println(Integer.MAX_VALUE + 1 < Integer.MAX_VALUE);


    }
}
