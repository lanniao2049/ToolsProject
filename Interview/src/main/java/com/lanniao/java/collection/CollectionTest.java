package com.lanniao.java.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class CollectionTest {

    /**
     * add(),addAll(),size(),hashCode(),toString()
     */
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        System.out.println(coll);
        Collection coll1 = new ArrayList();
        coll.add(45.8);
        coll.add('a');
        coll.addAll(coll1);
        System.out.println(coll);
        System.out.println(coll.size());
        System.out.println(coll.hashCode());
        System.out.println(coll.toString());
    }

    /**
     * 集合的方法contains(),containsAll(),isEmpty(),clear()
     */
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        boolean contains = coll.contains(123);
        System.out.println(contains);
        boolean contains1 = coll.contains(new String("hello everyone!"));
        System.out.println(contains1);
        // 注意集合调用contains()的方法时候一定要重写相应对象的equal()方法
        boolean contains2 = coll.contains(new Person("Jack", 18));
        System.out.println(contains2);
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add(4567);
        boolean b = coll.containsAll(c1);
        System.out.println(b);
        boolean empty = coll.isEmpty();
        System.out.println(empty);
        coll.clear();
        System.out.println(coll.isEmpty());
    }

    /**
     * 集合的方法 remove(),removeAll()
     */
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("789");
        coll.add(123);
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        System.out.println(coll);
        coll.remove(456);
        System.out.println(coll);
        coll.remove(1111);
        System.out.println(coll);
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add("789");
        coll.removeAll(c1);
        System.out.println(coll);
    }

    /**
     * equal()  必须注意顺序是否一致？
     */
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("789");
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        Collection c1 = new ArrayList();
        c1.add(123);
        c1.add("789");
        c1.add(456);
        c1.add(456);
        c1.add("hello everyone!");
        c1.add(new Person("Jack",18));
        boolean equals = coll.equals(c1);
        System.out.println(equals);
    }

    /**
     * iterator()的使用:hasNext(),next()
     *  集合首先hasNext()指针第一元素之前,判断是否有元素，有进入下面的逻辑处理
     *  next()有两个作用：1，从hasNext()之前的指针下移到当前元素，2.返回当前元素的值
     */
    @Test
    public void test5(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("789");
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("-------------------");

        Iterator iterator2 = coll.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            if (next.equals("789")){
                iterator2.remove();
            }
        }
        System.out.println(coll);
        // 错误使用2
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
        // 错误使用1
        Iterator iterator1 = coll.iterator();
        while (iterator1.next()!=null){
            System.out.println(iterator1.next());
        }

    }

    /**
     * 集合 toArray()方法和forEach循环
     */
    @Test
    public void test6(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("789");
        coll.add(456);
        coll.add("hello everyone!");
        coll.add(new Person("Jack",18));
        Object[] objects = coll.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

        List<Object> objects1 = Arrays.asList(objects);
        for (Object o : objects1) {
            System.out.println(o);
        }

    }

}

class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
