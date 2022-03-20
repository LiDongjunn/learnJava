package com.falltwo.bilibili1.threadPool.demo03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 22:54
 * @description:
 */
public class ScheduleExecutorService03 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                int n=1;
                return new Thread(r,"线程："+n++);
            }
        });

        scheduledExecutorService.scheduleWithFixedDelay(new MyRunnable2(1),3,2,TimeUnit.SECONDS);

//        scheduledExecutorService.shutdown();
        System.out.println("main over");
    }

}

class MyRunnable3 implements Runnable{
    int id;

    MyRunnable3(int id){
        this.id = id;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"执行任务  "+id);
    }
}