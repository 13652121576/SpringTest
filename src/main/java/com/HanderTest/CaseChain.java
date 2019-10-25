package com.HanderTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: springmvc
 * @Package: com.HanderTest
 * @ClassName: CaseChain
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/10/24 11:10
 * @Version: 1.0
 */
public class CaseChain implements BaseCase {
    // 所有 case 列表
    private List<BaseCase> mCaseList = new ArrayList<>();
    // 索引，用于遍历所有 case 列表
    private int index = 0;
    // 添加 case
    public CaseChain addBaseCase(BaseCase baseCase) {
        mCaseList.add(baseCase);
        return this;
    }

    @Override
    public void doSomething(String input, BaseCase baseCase) {
        // 所有遍历完了，直接返回
        if (index == mCaseList.size()) {return;}
        // 获取当前 case
        BaseCase currentCase = mCaseList.get(index);
        // 修改索引值，以便下次回调获取下个节点，达到遍历效果
        index++;
        // 调用 当前 case 处理方法
        currentCase.doSomething(input, this);
    }
}
