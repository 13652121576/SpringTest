package com.sort;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: springmvc
 * @Package: com.sort
 * @ClassName: SortDemo
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/11/7 15:43
 * @Version: 1.0
 */
public class SortDemo {
    public static void sort(int array[]){
        int temp =0;
        //记录最后一次交换位置的下标
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length-1;
        for (int i = 0 ;i<array.length;i++){
            boolean a =true;
            for (int j=0;j<sortBorder;j++){
                if(array[j]<array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    a=false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex=j;
                }
            }
            sortBorder=lastExchangeIndex;
            if(a){
                break;
            }
        }
    }


    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        Object bean = classPathXmlApplicationContext.getBean("");
        System.out.println (new StringBuilder ().append ("Byte-->>").append ("字节数：").append (Byte.BYTES).append (";位数：").
                append (Byte.SIZE).append ("; 最小值-->最大值:").append (Byte.MIN_VALUE).append ("-->").append (Byte.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Short-->>").append ("字节数：").append (Short.BYTES).append (";位数：").
                append (Short.SIZE).append ("; 最小值-->最大值:").append (Short.MIN_VALUE).append ("-->").append (Short.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Integer-->>").append ("字节数：").append (Integer.BYTES).append (";位数：").
                append (Integer.SIZE).append ("; 最小值-->最大值:").append (Integer.MIN_VALUE).append ("-->").append (Integer.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Long-->>").append ("字节数：").append (Long.BYTES).append (";位数：").
                append (Long.SIZE).append ("; 最小值-->最大值:").append (Long.MIN_VALUE).append ("-->").append (Long.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Float-->>").append ("字节数：").append (Float.BYTES).append (";位数：").
                append (Float.SIZE).append ("; 最小值-->最大值:").append (Float.MIN_VALUE).append ("-->").append (Float.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Double-->>").append ("字节数：").append (Double.BYTES).append (";位数：").
                append (Double.SIZE).append ("; 最小值-->最大值:").append (Double.MIN_VALUE).append ("-->").append (Double.MAX_VALUE));
        System.out.println (new StringBuilder ().append ("Character-->>").append ("字节数：").append (Character.BYTES).append (";位数：").
                append (Character.SIZE).append ("; 最小值-->最大值:").append ((int)Character.MIN_VALUE).append ("-->").append ((int)Character.MAX_VALUE));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123");
        AtomicInteger integer = new AtomicInteger();



//        int[] array = new int[]{8,6,4,5,9,3,1,0,7,2};
//        sort(array);
//        System.out.println(Arrays.toString(array));
    }
    public final static ThreadLocal<String> RESOURCE = new ThreadLocal<String>();
}
