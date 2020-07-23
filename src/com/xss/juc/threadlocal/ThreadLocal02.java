package com.xss.juc.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal02
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 5:03 下午
 * @Return
 */
public class ThreadLocal02 {
    //ThreadLocal设置的对象,是线程独有的,其他线程访问不到
    static ThreadLocal<Person> p = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //设到了当前线程的map中
            p.set(new Person());
        }).start();
    }
    static class Person{
        String name ="zhangsan";
    }
}

