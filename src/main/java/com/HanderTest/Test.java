package com.HanderTest;

/**
 * @ProjectName: springmvc
 * @Package: com.HanderTest
 * @ClassName: Test
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 11:12
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args){
        String input = "2";
        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase());
        caseChain.addBaseCase(new TwoCase());
        caseChain.doSomething(input, caseChain);
    }
}
