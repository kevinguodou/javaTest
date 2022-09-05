package com.example.demo.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnable start");
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable "+i);
        }
    }

}