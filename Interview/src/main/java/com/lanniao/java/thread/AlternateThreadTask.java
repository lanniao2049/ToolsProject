package com.lanniao.java.thread;

/**
 * 两个线程分别交替执行任务(且任务共享)，主要使用wait(),notify(),notifyAll()
 */
public class AlternateThreadTask {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.start();
        thread2.start();
    }

    /**
     * 总结
     *  1.wait(),notify(),notifyAll()必须在同步方法或者同步代码块内，使用同一个同步监视器
     *  2.wait(),notify(),notifyAll()必须使用同一个同步监视器，否则报错IllegalMonitorStateException
     */

    /**
     * sleep和wait的区别
     *  1.相同点：
     *      都可以线程阻塞
     *  2.不同点：
     *      2.1 sleep是Thread方法，wait是object方法
     *      2.2 位置不同，sleep可以任意位置，wait只能在有同步代码块或者同步方法内与notify()或者notifyAll()配合使用
     *      2.3 sleep线程阻塞不释放锁，wait线程阻塞释放锁
     */

    static class Number implements Runnable{
        private int number = 0;
        private Object object = new Object();
        @Override
        public void run() {
            while (true){
                synchronized(this){

                    object.notify();
//                    this.notify();

                    if (number <=100){
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"-"+number);
                        number++;

                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {
                        break;
                    }
                }
            }
        }
    }

}
