package com.LogLevel;

/**
 * @ProjectName: springmvc
 * @Package: com.LogLevel
 * @ClassName: ErrorLogger
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 15:20
 * @Version: 1.0
 */
/**
 * error日志处理器.
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

