package com.lanniao.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  待多个线程处理任务后返回处理时长
 *  1.join()
 *  2.CountDownLatch
 *  3.threadPool
 *  4.cyclicBarrier
 */
public class TaskDo {
    public static void main(String[] args) {
        cyclicBarrierWayForTask();
    }

    public static void cyclicBarrierWayForTask(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 处理真实的业务
                    for (int j = 0; j < 1000000000; j++) {
                        if (j%1000000==0){
                            System.out.println(Thread.currentThread().getName()+", j="+j);
                        }
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
        }
        // 返回主线程
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("任务处理完毕，返回主线程");
    }

    public static void threadPoolWayForTask(){
        int taskCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < taskCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // 处理真实的业务
                    for (int j = 0; j < 1000000000; j++) {
                        if (j%1000000==0){
                            System.out.println(Thread.currentThread().getName()+", j="+j);
                        }
                    }
                }
            });
        }
        // 多线程处理完毕
        executorService.shutdown();
        while (true){
            if (executorService.isTerminated()){
                System.out.println("多线程处理完毕，返回主线程");
                break;
            }
        }
    }

    public static void countDownLatchWayForTask(){
        long begin = System.currentTimeMillis();
        int taskCount = 10;
        CountDownLatch latch = new CountDownLatch(taskCount);
        for (int i = 0; i < taskCount; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 处理真实的业务
                    for (int j = 0; j < 1000000000; j++) {
                        if (j%1000000==0){
                            System.out.println(Thread.currentThread().getName()+", j="+j);
                        }
                    }
                    latch.countDown();
                }
            });
            thread.start();
        }
        // 多线程任务处理完毕，返回主线程
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("任务处理完毕，返回主线程，耗时："+(end-begin)/1000+"s");
    }

    public static void joinWayForTask(){
        Vector<Thread> vector = new Vector<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000000; j++) {
                        if (j%1000==0){
                            System.out.println(Thread.currentThread().getName()+", j="+j);
                        }
                    }
                }
            });
            vector.add(thread);
            thread.start();
        }
        for (Thread thread : vector) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("任务处理完毕，返回主线程");
    }

}
