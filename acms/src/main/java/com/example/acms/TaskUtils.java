package com.example.acms;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskUtils {
    @Scheduled(cron = "0/2 * * * * ?")
    public void doTask(){
        System.out.println("我是定时任务~");
    }

}
