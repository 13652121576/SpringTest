package com.CurrentLimiting;

/**
 * @ProjectName: springmvc
 * @Package: com.CurrentLimiting
 * @ClassName: TokenBucket
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2020/3/12 9:35
 * @Version: 1.0
 */
public class TokenBucket {
    public static long timeStamp = getNowTime();
    public static int capacity = 500; // 桶的容量
    public static int rate = 10; // 令牌放入速度
    public static Long tokens = 0L; // 当前令牌数量
    public static boolean grant() {
        long now = getNowTime();
        // 先添加令牌
        tokens = Math.min(capacity, tokens + (now - timeStamp) * rate);
        timeStamp = now;
        if (tokens < 1) {
            // 若不到1个令牌,则拒绝
            return false;
        }
        else {
            // 还有令牌，领取令牌
            tokens -= 1;
            return true;
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
