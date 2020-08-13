package com.xss.juc.collections;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName CopyOnWriteTest
 * @Description 写时复制
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/8/13 1:43 下午
 * @Return
 */
public class CopyOnWriteTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        //写入元素的时候加锁,把当前list拷贝一份,并且在原来的基础上+1个元素的长度,然后把要添加的元素添加到最后一个位置.
        //最后setArray(),把add完之后的list添加进去.
        list.add("sss");
        System.out.println(list.get(0));
        list.add("ddd");
        System.out.println(list.get(1));

        //读取元素是不加锁的,该容器适用于写入操作少,读取操作多的场景
    }
}
