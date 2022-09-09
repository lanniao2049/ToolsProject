package com.lanniao.java.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLString {
    // 表列名称
    String name() default "";
    // 长度  varchar2(20)
    int value() default 0;
    Constraint constraint() default @Constraint;
}
