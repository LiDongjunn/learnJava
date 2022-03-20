package com.falltwo.bilibili1.threadPool.demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 21:18
 * @description:
 */
public class MyTest01 {
    public static void main(String[] args) {
//        test1();
        test2();

        List<Integer> a = new ArrayList<>();
    }


    private static void test1() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++){
            executorService.submit(new MyRunnable(i));
        }
    }

    private static void test2() {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            int n = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"线程名称： "+n++);
            }
        });

        for (int i = 0; i < 100; i++){
            executorService.submit(new MyRunnable(i));
        }
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
