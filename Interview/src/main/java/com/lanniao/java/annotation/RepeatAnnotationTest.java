package com.lanniao.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatAnnotationTest {
    @Column("userName")
    @Column("accountName")
    private String name;
    private double salary;
    private String university;

    @Column("/learn")
    @Column("/study")
    public void study(){

    }
    public void makeMoney(){

    }

}

/**
 * 1.8以后的最新最新可重复注解功能，@Repeatable
 * 1. @Retention和@Target最好一致；其中一个注解是单个元素的注解，上面必须有@Repeatable(xxxS.class)，另一个注解
 *      必须是数组的注解，其中方法包含单个元素……
 *
 *      具体案例如下：
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Repeatable(Columns.class)
@interface Column{
    String value() default "id";
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@interface Columns{
    Column[] value();
}
