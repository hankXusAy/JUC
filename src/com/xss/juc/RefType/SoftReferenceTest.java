package com.xss.juc.RefType;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReference
 * @Description     软引用-可以做缓存用
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 6:07 下午
 * @Return
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println("回收前"+m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("回收后"+m.get());
        //再分配一个byte数组,heap装不下,这时候系统会进行垃圾回收,先回收一次,如果不够,会直接把软引用回收掉
        byte[] b = new byte[1024*1024*15];
        System.out.println(m.get());
    }
}
