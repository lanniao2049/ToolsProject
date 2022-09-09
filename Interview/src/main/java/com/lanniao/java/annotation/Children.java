package com.lanniao.java.annotation;

import java.lang.annotation.Annotation;

public class Children extends Parent {
    public static void main(String[] args) {
        Class<Children> childrenClass  = Children.class;
        Annotation[] annotations = childrenClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
