package com.lanniao.java.annotation;

import java.util.Arrays;
import java.util.Comparator;

@MyAnnotation(name = "",description = "")
public class Parent {
    public static void makeProduct(){

    }
    public void fly(){

    }
    /**
     * 使用1.8jdk的最新注解功能：类型注解（TYPE_USE,TYPE_PARAMETER）
     * @param name
     * @param salary
     * @throws @MyAnnotation Exception
     */
    public void makeMoney(@MyAnnotation String name,@MyAnnotation Double salary) throws @MyAnnotation Exception{
        double sal = salary;
    }

    public void compare(){
        String[] strings = {"CC","EE","GG","AA","HH"};
        Arrays.sort(strings, new Comparator<@MyAnnotation String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
