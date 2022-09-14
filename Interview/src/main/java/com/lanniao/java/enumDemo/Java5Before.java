package com.lanniao.java.enumDemo;

import org.junit.Test;

/**
 * 1. 5.0之前的特征
 * 2. 1.5之后的特征
 * 3. 枚举实现接口
 * 4. 枚举实现接口定制
 */
public class Java5Before {

    @Test
    public void test1(){
        System.out.println(Season.SPRING);
        System.out.println(Season.WINTER.getName());
    }

    @Test
    public void test2(){
        System.out.println(Season1.SPRING);
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            System.out.println(value);
        }
        System.out.println(Season1.valueOf("WINTER"));
        // 异常情况
        System.out.println(Season1.valueOf("WINTER1"));

    }

    @Test
    public void test3(){
        Play play = Season1.SPRING;
        System.out.println(Season1.SUMMER.getClass().getSuperclass().getSuperclass());
        play.goToStudy();
        Season1[] values = Season1.values();
        for (Season1 value : values) {
            value.goToStudy();
        }
    }

}

class Season{
    private final String name;
    private final String desc;
    private Season(String name,String desc){
        this.name = name;
        this.desc = desc;
    }
    public static final Season SPRING = new Season("Spring","春暖花开");
    public static final Season SUMMER = new Season("Summer","夏日炎炎");
    public static final Season AUTUMN = new Season("Autumn","秋高气爽");
    public static final Season WINTER = new Season("Winter","寒风刺骨");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/**
 * 1.5之后新的特征
 */
enum Season1 implements Play{
    SPRING("Spring","春都昆明"){
        @Override
        public void goToStudy() {
            System.out.println("我在美丽的春城昆明欢迎您！");
        }
    },SUMMER("Summer","夏都武汉"){
        @Override
        public void goToStudy() {
            System.out.println("武汉大学欢迎您！");
        }
    },AUTUMN("Autumn","北京"){
        @Override
        public void goToStudy() {
            System.out.println("清华大学欢迎您！");
        }
    },WINTER("Winter","哈尔滨"){
        @Override
        public void goToStudy() {
            System.out.println("冰都哈尔滨欢迎您！");
        }
    };
    private final String name;
    private final String desc;
    private Season1(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public void goToStudy() {
        System.out.println("每个人都应该在该学习的时候好好学习");
    }
}

interface Play{
    void goToStudy();
}
