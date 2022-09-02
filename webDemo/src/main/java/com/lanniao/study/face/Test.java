package com.lanniao.study.face;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        listTest();
    }

    public static void listTest(){
        List<String> list = new ArrayList<>();
        list.add("good");
        list.add("goods");
        list.add("wood");
        list.add("food");
        list.add("hood");
        list.add("mood");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("wood")){
                iterator.remove();
                continue;
            }
            System.out.println(next);
        }
    }
}
