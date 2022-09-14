package com.lanniao.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Inherited
public @interface MyAnnotation {
    String description() default "";
    String name() default "";
}
