package com.example.acms;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;

public class MyScheduledExecutorService {

    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//
//        scheduledExecutorService.scheduleAtFixedRate(()->{
//            System.out.println("Run Schedule：" + new Date());
//        },1,3, TimeUnit.SECONDS); // 1s 后开始执行，每 3s 执行一次



        //FutureTask 可以获取线程的执行情况
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了");
                return "call方法返回值";
            }
        });
        futureTask.run();
       try {
           System.out.println("获取返回值: " + futureTask.get());
       }catch (Exception e){

       }
        FutureTask futureTask1= new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了1");
                return "call方法返回值1";
            }
        });
        futureTask1.run();
        try {
            System.out.println("获取返回值1: " + futureTask1.get());
        }catch (Exception e){

        }

    }
}
