package com.lanniao.java.base;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientTest {

    @Test
    public void test1(){
       UserName1 userName1 = new UserName1();
       userName1.setName("acbc@11");
       userName1.setPwd("@df87&");
       System.out.println("before info is username="+userName1.getName()+",pwd="+userName1.getPwd());
       String file = "d:\\test.txt";
       File filename = new File(file);
       if (!filename.exists()){
           try {
               filename.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       // 序列化并写入到文件中
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(userName1);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化产从文件中读取
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            UserName1 o = (UserName1) ois.readObject();
            ois.close();

            System.out.println("after user info username="+o.getName()+",pwd="+o.getPwd());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        UserName2 userName2 = new UserName2();
        userName2.setName("1bcacbc@11");
        userName2.setPwd("1e@df87&");
        System.out.println("before username1 info is username="+userName2.getName()+",pwd="+userName2.getPwd());
        String file = "d:\\test1.txt";
        File filename = new File(file);
        if (!filename.exists()){
            try {
                filename.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 序列化并写入到文件中
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
            os.writeObject(userName2);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化产从文件中读取
        try {
            UserName2.pwd="111111111111";
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            UserName2 o = (UserName2) ois.readObject();
            ois.close();
            System.out.println("after user info username="+o.getName()+",pwd="+o.getPwd());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

class UserName1 implements Serializable {
    private String name;
    // transient的使用
    private transient String pwd;
    public UserName1(){}
    public UserName1(String name,String pwd){
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserName1{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}


class UserName2 implements Serializable {
    private String name;
    // transient的使用
    public static transient String pwd;
    public UserName2(){}
    public UserName2(String name,String pwd){
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserName1{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}