package com.xss.juc.RefType;

/**
 * @ClassName M
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/23 6:00 下午
 * @Return
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
