package com.lanniao.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile保证了可见性和进制指令重排，但是原子性无法保证
 */
public class VolatileTest {

    // 针对n++,++n等，volatile无法保证原子性
    // 第一种情况:   volatile
//    private volatile int number = 0;
//    public void increase(){
//        number++;
//    }

    // 第二种情况使用同步锁：  synchronized
//    private int number = 0;
//    public synchronized void increase(){
//        number++;
//    }

    // 第三种情况使用lock锁：lock
//    private int number = 0;
//    Lock lock = new ReentrantLock();
//    public void increase(){
//        lock.lock();
//        try {
//            number++;
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//        }
//    }

    // 第四种情况使用AtomicInteger
    private AtomicInteger number = new AtomicInteger();
    public void increase(){
        number.getAndIncrement();
    }

    public static void main(String[] args) {
        VolatileTest test  = new VolatileTest();
        CountDownLatch downLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                    System.out.println(Thread.currentThread().getName()+", number:"+test.number);
                    downLatch.countDown();
                }
            });
            thread.start();
        }
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.number);
    }


}
