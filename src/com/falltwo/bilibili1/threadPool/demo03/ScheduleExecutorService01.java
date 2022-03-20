package com.falltwo.bilibili1.threadPool.demo03;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 22:54
 * @description:
 */
public class ScheduleExecutorService01 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(3);
        for (int i = 0; i < 100; i++){
            scheduledExecutorService.schedule(new MyRunnable(i),3, TimeUnit.SECONDS);

        }
        scheduledExecutorService.shutdown();
        System.out.println("main over");
    }

}
class MyRunnable implements Runnable{
    int id;

    MyRunnable(int id){
        this.id = id;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行任务  "+id);
    }
}