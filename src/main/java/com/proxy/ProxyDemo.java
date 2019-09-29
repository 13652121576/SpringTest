package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: springmvc
 * @Package: com.proxy
 * @ClassName: ProxyDemo
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/12 11:38
 * @Version: 1.0
 */
public class ProxyDemo {
    public static void main(String[] args){

        PersonImpl person = new PersonImpl();
        Person persion = (Person)Proxy.newProxyInstance(person.getClass().getClassLoader(), new Class[]{Person.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("先吃饭啊。。。");
                return method.invoke(person,args);
            }
        });
        persion.run();

        // 利用 Method 的 invoke 方法调用 System.currentTimeMillis()
        Method method = null;
        try {
            method = System.class.getMethod("currentTimeMillis");
            System.out.println(method);
            System.out.println(method.invoke(null));
        } catch (Exception e) {
            e.printStackTrace();
        }


        Method[] methods = person.getClass().getMethods();
        try {
            PersonImpl person1 = person.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(methods[0]);
    }

}
