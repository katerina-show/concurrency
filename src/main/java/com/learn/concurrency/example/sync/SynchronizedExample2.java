package com.learn.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Katerina
 * @Date: 2018/8/8 20:01
 * @Description: Synchronized关键字使用说明
 **/
@Slf4j
public class SynchronizedExample2 {

    //3.修饰一个类，作用于所有对象
    public static void test1(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++){
                log.info("test1 - {}-{}",j,i);
            }
        }
    }

    //4.修饰一个静态方法,作用于所有对象 3和4效果等价
    public static synchronized void test2(int j){
            for (int i = 0; i < 10; i++){
                log.info("test2 - {}-{}",j,i);
            }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
