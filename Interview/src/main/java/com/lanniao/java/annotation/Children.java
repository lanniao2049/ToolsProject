package com.lanniao.java.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;

public class Children extends Parent {
    public static void main(String[] args) {
        Class<Children> childrenClass  = Children.class;
        Annotation[] annotations = childrenClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    /**
     * 这是个test的注解
     */
    @Test
    public static void test1(){

    }


    @Deprecated
    @SuppressWarnings("uncheck")
    public void test2(){

    }

    @Override
    public void fly() {

    }
}
