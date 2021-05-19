package com.example.acms;


import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPookTest {

    /**
     * 拒绝策略测试
     * @throws Exception
     */
    @Test
    public void testThreadPoolExecutorReject() throws Exception{
        System.out.println("11111111111");
        int corePoolSize = 1;
        int maxPoolSize = 1;
        long keepActiveTime = 60;
        TimeUnit unint = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "run");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepActiveTime,unint,workQueue);

        try {
            threadPoolExecutor.execute(runnable);
            threadPoolExecutor.execute(runnable);
            threadPoolExecutor.execute(runnable);//拒绝策略
        }catch (Exception e){
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(5,TimeUnit.SECONDS);
    }

}
