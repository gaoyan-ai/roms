package com.example.acms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoutDownLatchTest {
////  参数count为计数值
//    public CountDownLatch(int count) {  };
//    //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
//    public void await() throws InterruptedException { };
//    //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
//    public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
//    //将count值减1
//    public void countDown() { };
    public static void main(String[] args) {
       final CountDownLatch countDownLatch = new CountDownLatch(2);

        System.out.println("主线程开启");

        ExecutorService es1 =
                Executors.newSingleThreadExecutor();
        es1.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        });
        es1.shutdown();

        //第二个子线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
                countDownLatch.countDown();
            }
        });
        es2.shutdown();
        System.out.println("等待两个线程执行完毕…… ……");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }
}
