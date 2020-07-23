package com.xss.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestReetrentLock
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/22 7:19 下午
 * @Return
 */
public class TestReetrentLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
