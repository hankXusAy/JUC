package com.xss.juc.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadLocal01
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 4:53 下午
 * @Return
 */
public class ThreadLocal01 {
    volatile static Person p = new Person();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}
class Person{
    String name ="zhangsan";
}