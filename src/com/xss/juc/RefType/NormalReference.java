package com.xss.juc.RefType;

import java.io.IOException;

/**
 * @ClassName NormalReference
 * @Description   强引用-只有当当前引用没有指向任何堆内存时,才会被回收
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 6:01 下午
 * @Return
 */
public class NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();

        //阻塞当前main线程
        System.in.read();
    }
}
