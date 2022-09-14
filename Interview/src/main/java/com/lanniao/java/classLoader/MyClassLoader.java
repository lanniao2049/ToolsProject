package com.lanniao.java.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String root;
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name,classData,0,classData.length);
        }
    }

    private byte[] loadClassData(String fileName){
        String file = root + File.separator + fileName.replace(".", File.separator) + ".class";
        try {
            InputStream ism = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int byteSize = 1024;
            byte[] buff = new byte[byteSize];
            int length = 0;
            while ((length=ism.read(buff))!=-1){
                baos.write(buff,0,length);
            }
            return baos.toByteArray();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) {
        MyClassLoader classLoader  = new MyClassLoader();
        classLoader.setRoot("D:\\git\\");
        Class<?> clazz = null;
        try {
            clazz = classLoader.loadClass("com.lanniao.java.classLoader.Test");
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
