package com.lanniao.java.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

    /**
     * 测试自然排序，string继承的comparable
     */
    @Test
    public void test1(){
        String[] strings = {"AA","GG","LL","HH","QQ","BB","XX","PP"};
        Arrays.sort(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    /**
     * 测试自然排序，重写
     */
    @Test
    public void test2(){
        Goods[] goods = new Goods[8];
        goods[0] = new Goods("levnoMouse",23.8);
        goods[1] = new Goods("levnoMouse",29.8);
        goods[2] = new Goods("dellMouse",33.6);
        goods[3] = new Goods("micMouse",53.8);
        goods[4] = new Goods("thinkpadMouse",45.2);
        goods[5] = new Goods("micMouse",67.1);
        goods[6] = new Goods("micMouse",45.1);
        goods[7] = new Goods("micMouse",97.1);

        Arrays.sort(goods);
        for (Goods good : goods) {
            System.out.println(good);
        }

    }

    /**
     * 使用comparator临时对比
     */
    @Test
    public void test3(){
        Goods[] gs = new Goods[8];
        gs[0] = new Goods("levnoMouse",23.8);
        gs[1] = new Goods("levnoMouse",29.8);
        gs[2] = new Goods("dellMouse",33.6);
        gs[3] = new Goods("micMouse",53.8);
        gs[4] = new Goods("thinkpadMouse",45.2);
        gs[5] = new Goods("micMouse",67.1);
        gs[6] = new Goods("micMouse",45.1);
        gs[7] = new Goods("micMouse",97.1);

        Arrays.sort(gs, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().compareTo(g2.getName())==0){
                        if (g1.getPrice()>g2.getPrice()){
                            return 1;
                        } else if (g1.getPrice()<g2.getPrice()){
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                    return -g1.getName().compareTo(g2.getName());
                } else {
                    throw new RuntimeException("类型异常，请检查！！！");
                }
            }
        });
        for (Goods g : gs) {
            System.out.println(g);
        }
    }

}

class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(){

    }

    public Goods(String name,double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    /**
     * 比较对象大小，先比较从大到小姓名，然后再比较价格，从小到大排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods  = (Goods) o;
            if (this.name.compareTo(goods.name)==0){
              if (this.price>goods.price){
                  return 1;
              } else if (this.price<goods.price){
                  return -1;
              } else {
                  return 0;
              }
            }
            return -this.name.compareTo(goods.name);
        } else {
            throw new RuntimeException("数据类型异常，请检查");
        }
    }
}
