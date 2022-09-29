package com.example.demo.thread.wait;

/**
 * @author dou.guo
 * @version Worker, v 0.1 2022-09-28 5:27 下午 dou.guo Exp $
 */
public class Worker {

    public static void main(String[] args) {
        Job job =new Job();

        //开启一个线程定时去添加任务
        Thread addThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    job.add("work_"+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        addThread.start();

        //开启多个线程去完成任务
        Thread workThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                job.work();
            }
        });
        workThread1.start();

        Thread workThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                job.work();
            }
        });
        workThread2.start();
    }


}
