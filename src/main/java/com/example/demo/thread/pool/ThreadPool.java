package com.example.demo.thread.pool;


import com.google.common.util.concurrent.Futures;

import java.util.concurrent.*;

/**
 * @author dou.guo
 * @version ThreadPool, v 0.1 2022-10-13 11:11 上午 dou.guo Exp $
 */
public class ThreadPool {

    private static ExecutorService xcuteservice = new ThreadPoolExecutor(8, 16, 5, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(30), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    });

    public static void main(String[] args) {
        xcuteservice.execute(null);
    }
}
