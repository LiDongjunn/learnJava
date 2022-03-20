package com.falltwo.bilibili1.threadPool.demo02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 21:18
 * @description:
 */
public class MyTest03 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++){
            executorService.submit(new MyRunnable3(i));
        }
        executorService.shutdown();
    }

    private static void test2() {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"线程名称： "+n++);
            }
        });

        for (int i = 0; i < 100; i++){
            executorService.submit(new MyRunnable3(i));
        }
        executorService.shutdown();
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
        System.out.println(name+"执行任务  "+id);
    }
}
