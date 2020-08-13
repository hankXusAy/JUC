package com.xss.juc.collections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @ClassName QueueTest
 * @Description 队列集合
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/8/13 2:01 下午
 * @Return
 */
public class QueueTest {
    public static void main(String[] args) {

        //无界队列 新增put和take,如何为空,会阻塞当前线程
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        try {
            blockingQueue.put("aa");
            String take = blockingQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Queue<String> queue = new ConcurrentLinkedQueue<>();
        //对线程友好的API  offer,peek,poll
        for (int j = 0; j < 10; j++) {
            queue.offer("test" + j);
        }
        System.out.println(queue);
        //获取元素
        System.out.println(queue.peek());
        //获取之后删除元素
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
