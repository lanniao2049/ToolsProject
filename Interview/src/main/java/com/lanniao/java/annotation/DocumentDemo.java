package com.lanniao.java.annotation;

import javax.print.Doc;
import java.lang.annotation.Annotation;
import java.util.Arrays;

//@DocumentA
@DocumentB
public class DocumentDemo extends A {
    public void A(){

    }

    public static void main(String[] args) {
//        A a = new B();
//        System.out.println("a:"+ Arrays.toString(a.getClass().getAnnotations()));
//        C c = new D();
//        System.out.println("c:"+Arrays.toString(c.getClass().getAnnotations()));

        Class<?> clazz = DocumentDemo.class;
        // 根据指定的注解获取该注解
        DocumentA annotation = clazz.getAnnotation(DocumentA.class);
        System.out.println("a: "+annotation);
        // 获取该元素上所有的注解
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("an: " + Arrays.toString(annotations));
        // 获取该元素上所有的注解，但不包括继承
        Annotation[] annotations1 = clazz.getDeclaredAnnotations();
        System.out.println("an1: "+Arrays.toString(annotations1));

        // 判断该元素上是否存在该注解
        boolean flag = clazz.isAnnotationPresent(DocumentA.class);
        System.out.println("flag: "+flag);
    }


}
    @DocumentA
    class A{

    }

    class B extends A{

    }

    @DocumentB
    class C{

    }
    class D extends C{

    }
