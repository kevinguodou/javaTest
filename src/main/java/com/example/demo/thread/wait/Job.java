package com.example.demo.thread.wait;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author dou.guo
 * @version job, v 0.1 2022-09-28 5:14 下午 dou.guo Exp $
 */
public class Job {

    private Queue<String> queue = new ArrayBlockingQueue(10);

    /**
     * 向任务列表中添加一个任务
     *
     * @param workName
     */
    synchronized void add(String workName) {

        queue.add(workName);
        System.out.println("添加任务：" + queue);

        //需要通知所有在waiting中的线程
        this.notifyAll();
    }

    /**
     * 完成任务列表中最早插入的一个任务
     */
    void work() {
        try {
            //对job类的当前实体进行加锁
            synchronized (this) {

                //队列中可能没有任务了,线程就一直等待，直到有新的任务
                while (queue.isEmpty()) {
                    //如果队列中可能没有任务，需要释放锁；同时添加任务线程拿到锁，可以正常执行add方法
                    System.out.println("等。。。。。。");
                    this.wait();
                }

                queue.remove();
                System.out.println("执行完毕：" + queue);
            }
        } catch (Exception e) {

        }
    }

}
