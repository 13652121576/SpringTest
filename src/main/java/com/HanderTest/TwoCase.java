package com.HanderTest;

/**
 * @ProjectName: springmvc
 * @Package: com.HanderTest
 * @ClassName: CaseChain
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 11:10
 * @Version: 1.0
 */
public class TwoCase implements BaseCase {

    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if ("2".equals(input)) {
            // TODO do something
            System.out.println(getClass().getName());
            return;
        }
        //当前没法处理，回调回去，让下一个去处理
        baseCase.doSomething(input, baseCase);
    }
}
