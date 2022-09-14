package com.lanniao.java.classLoader;

public class TestMain {
    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}

