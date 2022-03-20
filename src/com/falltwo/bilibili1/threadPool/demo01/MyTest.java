package com.falltwo.bilibili1.threadPool.demo01;

/**
 * @author: FallTwo
 * @createTime: 2022/3/20 20:53
 * @description:
 */
public class MyTest {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(2, 4, 20);
        for (int i = 0; i < 50; i++){
            MyTask myTask = new MyTask(i);
            myThreadPool.submit(myTask);
        }
    }
}
