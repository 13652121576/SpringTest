package com.demo;

import com.demo.pojo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @ProjectName: springmvc
 * @Package: cn.demo
 * @ClassName: testController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/2 14:58
 * @Version: 1.0
 */
@Controller
@RequestMapping("admin")
public class testController {
    @RequestMapping("/hi")
    @ResponseBody
    public String show(){
        System.out.println("welcome");
        return "index";
    }



    public static void main(String[] args) {
        Person person = new Person();
        Class<Person> personClass = Person.class;
        //DeclaredField获取对象中的属性
        Field[] fields = personClass.getDeclaredFields();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("123");
        strings.add("456");
        strings.add("789");
        strings.add("000");
        strings.stream().forEach(stirng->{
            System.out.println(stirng);
        });
        for (int i =0; i<=fields.length-1;i++){
            System.out.println(fields[i].getGenericType());
        }

    }




}
