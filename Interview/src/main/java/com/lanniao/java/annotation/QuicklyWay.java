package com.lanniao.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface IntegerValue{
    int value() default 0;
    String name() default "";
}
public class QuicklyWay {
    @IntegerValue(20)
    private int age;

    @IntegerValue(value = 18,name = "长城长城，我是长江")
    private String name;
}
