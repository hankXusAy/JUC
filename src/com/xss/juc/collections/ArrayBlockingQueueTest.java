package com.xss.juc.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ArrayBlockingQueueTest
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/8/13 2:36 下午
 * @Return
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        //可以设置元素个数
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            //put满了也会阻塞住当前线程
            arrayBlockingQueue.put("test" + i);
        }
        System.out.println("poll :" + arrayBlockingQueue);
        for (int i = 0; i < 10; i++) {
            //take,如果为空,会阻塞当前线程
            arrayBlockingQueue.take();
        }
        System.out.println(arrayBlockingQueue);

        arrayBlockingQueue.offer("ddd");
        arrayBlockingQueue.offer("ooo",1, TimeUnit.SECONDS);
//        arrayBlockingQueue.put("test888888");
//        arrayBlockingQueue.take();
//        System.out.println("阻塞了 :" + arrayBlockingQueue);
//        arrayBlockingQueue.put("test999999");
//        System.out.println("take :" + arrayBlockingQueue);
    }
}
