package com.LogLevel;

/**
 * @ProjectName: springmvc
 * @Package: com.LogLevel
 * @ClassName: ConsoleLogger
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 15:19
 * @Version: 1.0
 */
/**
 * 控制台处理器.
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger :"+message);
    }
}
