package com.light.springboot.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator
 * on 2018/4/24.
 */
//@Repository
public class QueueQuests {
    // 篮子，能够容纳3个苹果
   private static BlockingQueue<Object> basket = new ArrayBlockingQueue<>(9999);

    // 生产苹果，放入篮子
    public static void produce(Object obj) throws InterruptedException{
        // put方法放入一个苹果，若basket满了，等到basket有位置
        basket.put(obj);
    }
    // 消费苹果，从篮子中取走
    public static Object consume() throws InterruptedException{
        // get方法取出一个苹果，若basket为空，等到basket有苹果为止
        return basket.take();
    }

    public int getAppleNumber(){
        return basket.size();
    }
}
