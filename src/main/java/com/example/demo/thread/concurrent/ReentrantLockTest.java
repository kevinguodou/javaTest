package com.example.demo.thread.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dou.guo
 * @version ReentrantLockTest, v 0.1 2022-09-05 3:22 下午 dou.guo Exp $
 */
public class ReentrantLockTest {

    private int count;

    private Lock reentrantLock = new ReentrantLock();

    void add(int n){
        synchronized (this){
            count=+n;
        }
    }

    /**
     * synchronized会导致线程等待，死锁问题
     * 可重入锁ReentrantLock可以尝试获取锁
     */
    void minus(int n) throws InterruptedException {

        //尝试获取锁,获取不到就处理其他任务，这样就避免了死锁问题
        if (!reentrantLock.tryLock(1, TimeUnit.SECONDS)){
            return;
        }

        //reentrantLock.lock();
        try {
            count=-n;
        }finally {
            //释放锁
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
