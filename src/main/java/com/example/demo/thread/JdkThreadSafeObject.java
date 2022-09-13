package com.example.demo.thread;

/**
 * @author dou.guo
 * @version JdkThreadSafeObject, v 0.1 2022-09-02 5:32 下午 dou.guo Exp $
 */
public class JdkThreadSafeObject {


    public static void main(String[] args) {
        //final类,只能读不能写，所以是线程安全的
        String a = "11";
        Integer b = 11;

        //线程安全类
        StringBuffer buffer = new StringBuffer();

        //只有静态方法，没有成员变量
        Math.random();
    }

}
