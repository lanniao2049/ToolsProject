package com.lanniao.java.string;

public class SpiltTest {

    /**
     * spilt 使用时
     * spilt(",")和spilt(",",0)等同，无限切割去掉数组后面的所有空字符串
     * spilt(",",1) 等于切割(n-1)即0次，等同于原来字符串
     * spilt(",",-1) 无限切割且不去掉字符串后面所有的空字符串
     * spilt(",",3) 有限切换(n-1)次即2次
     * @param args
     */
    public static void main(String[] args) {
        String str = ",,,a,b,c,d,e,g,1,3,,,,2,,,,,,";
        String[] split = str.split(",",3);
        System.out.println("切割后的长度时候："+split.length);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
