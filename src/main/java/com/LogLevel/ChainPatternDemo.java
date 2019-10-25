package com.LogLevel;

/**
 * @ProjectName: springmvc
 * @Package: com.LogLevel
 * @ClassName: ChainPatternDemo
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 15:31
 * @Version: 1.0
 */
/**
 * 处理链.
 */
public class ChainPatternDemo {

    public static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return  errorLogger;
    }
    
    
    public static void main(String[] args){
        AbstractLogger logger = ChainPatternDemo.getChainOfLoggers();
        logger.logMessage(1,"一级日志记录");
        System.out.println("--------------------------------");
        logger.logMessage(2,"二级日志记录");
        System.out.println("--------------------------------");
        logger.logMessage(3,"三级日志记录");
    }
}

