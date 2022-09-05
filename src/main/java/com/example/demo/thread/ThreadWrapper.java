package com.example.demo.thread;

/**
 * @author dou.guo
 * @version ThreadWrapper, v 0.1 2022-09-02 2:15 下午 dou.guo Exp $
 */
public class ThreadWrapper {

    //直接生成runnable实体
    static void evovkThread1(){
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("evovkThread1() start");
            }
        });
        myThread.start();
    }

    //lambda函数式表达
    static void evovkThread2() {
        Thread myThread = new Thread(() -> {
            System.out.println("evovkThread2() start");
            for (int i = 0; i < 100; i++) {
                System.out.println("evovkThread2 "+i+"...");
            }
        });
        myThread.start();
        myThread.interrupt();
    }

    //实现runnable接口
    static void evovkThread3() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();
        myThread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");

        String invockMethordName = "evovkThread2";
        switch (invockMethordName) {
            case "evovkThread1":
                evovkThread1();
                break;
            case "evovkThread2":
                evovkThread2();
                break;
            case "evovkThread3":
                evovkThread3();
                break;
        }

        for (int i = 0; i < 100; i++) {
            //hardWork();
            System.out.println(i);
        }
        System.out.println("main thread end");
    }

    public static void hardWork(){
        for (int i = 0; i < 50; i++) {
            int j = new Integer(i);
        }
    }
}
