package com.falltwo.bilibili1.threadPool.demo01;

import java.util.List;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 20:35
 * @description:
 */
public class MyThread extends Thread{
    String name;
    List<Runnable> tasks;

    public MyThread(String name, List<Runnable> tasks) {
        super(name) ;
        this.tasks = tasks;
    }


    @Override
    public void run() {
        while (tasks.size() > 0){
            Runnable r = tasks.remove(0);
            r.run();
        }

    }
}
