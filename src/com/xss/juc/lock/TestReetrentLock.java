package com.xss.juc.lock;

import java.util.Collections;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/**
 * @ClassName TestReetrentLock
 * @Description     AQS
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/22 7:19 下午
 * @Return
 */
public class TestReetrentLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        //首先会调用tryRelease,试图释放锁,获取当前线程的state(每次线程加一次锁,该值会+1),减去1,然后判断是否为当前线程
        //如果是当前线程,判断state-1是否为0,如果为0,说明只有一把锁,将当前线程设为null,再将当前state设置为0,返回ture
        lock.unlock();

    }
}
