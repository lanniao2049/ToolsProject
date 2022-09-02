package com.lanniao.java.thread.futrue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 多线程处理，待处理完毕返回执行结果
 */
public class TaskResult {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 多线程
     */
    public static void test3(){

    }

    public static void test2(){
        Integer result = null;
        Task task = new Task();
        FutureTask<Integer> futureTask  = new FutureTask<>(task);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(futureTask);
        }
//        executorService.submit(futureTask);
        executorService.shutdown();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取线程处理结果
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程任务处理完毕，主线程获取执行结果是："+result);
    }

    public static void test1(){
        Integer result = null;
        Task task = new Task();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> integerFuture = executorService.submit(task);
        executorService.shutdown();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取执行线程的处理结果
        try {
            result = integerFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕，执行结果是："+result);
    }

    static class Task implements Callable<Integer>{
        private int num;
        public Task(){}
        public Task(int num){
            this.num = num;
        }

        @Override
        public Integer call() throws Exception {
            int count = 1000;
            int sum = 0;
            for (int i = 0; i < count; i++) {
                if (i%10 == 0){
                    sum += i;
                }
            }
            System.out.println("Thread name is "+Thread.currentThread().getName()+", result is "+sum);
            return sum;
        }
    }
}
