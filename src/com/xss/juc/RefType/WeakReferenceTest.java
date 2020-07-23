package com.xss.juc.RefType;

import org.w3c.dom.ls.LSOutput;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @ClassName WeakReferenceTest
 * @Description     弱引用-只要开始回收,就会被回收掉
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 6:26 下午
 * @Return
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        /*当一个强引用和一个弱引用同时指向m的时候,只要强引用消失了,就一定会被回收
        * ☆一般用在容器里☆*/
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> t1 = new ThreadLocal<>();
        t1.set(new M());
        //每次用完ThreadLocal之后,必须手动remove()掉,不然很容易导致内存溢出
        t1.remove();
        /*内存泄漏-有一块内存永远不会被回收
        * 内存溢出(OOM)内存不够了*/
        WeakHashMap weakHashMap = new WeakHashMap();
    }
}
