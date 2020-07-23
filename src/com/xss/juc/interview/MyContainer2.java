package com.xss.juc.interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName MyContainer1
 * @Description 面试题: 写一个固定容量的同步容器,拥有get和put方法,以及getCount方法,能够支持两个生产者线程以及
 *              十个消费者线程阻塞调用.
 *              使用wait和notify和notifyAll来实现
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/19 9:26 下午
 * @Return
 */
public class MyContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count  = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        lock.lock();
        try {
            while (lists.size() == MAX){
                producer.wait();
            }
            lists.add(t);
            ++count;
            consumer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        lock.lock();
        try {
            while (lists.size() == 0){
                consumer.wait();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }
    public static void main(String[] args) {
        MyContainer2 myContainer2 = new MyContainer2();
        myContainer2.put(new Object());
        MyContainer1<String> c = new MyContainer1<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    System.out.println(c.get());
                }
            },"c"+i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            },"p"+i).start();
        }
    }
}
