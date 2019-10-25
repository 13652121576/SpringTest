package com.LogLevel;

/**
 * @ProjectName: springmvc
 * @Package: com.LogLevel
 * @ClassName: FileLogger
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 15:19
 * @Version: 1.0
 */
/**
 * 文件处理器.
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File Console::Logger"+message);
    }
}
