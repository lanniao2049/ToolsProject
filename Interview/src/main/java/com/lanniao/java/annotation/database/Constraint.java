package com.lanniao.java.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constraint {
    // 是否是主键
    boolean primaryKey() default false;
    // 是否可以为null
    boolean allowNull() default false;
    // 是否为唯一主键
    boolean unique() default false;
}
