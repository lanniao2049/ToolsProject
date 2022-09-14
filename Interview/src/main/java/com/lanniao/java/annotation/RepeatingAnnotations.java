package com.lanniao.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RepeatingAnnotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Filters{
        Filter[] value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface FilterAble{

    }

    public static void main(String[] args) {
        Filter[] byType = FilterAble.class.getAnnotationsByType(Filter.class);
        for (Filter filter : byType) {
            System.out.println(filter.value());
        }
    }


}
