package com.example.demo.framwork.hsf.configserver;

import com.taobao.config.client.Subscriber;
import com.taobao.config.client.SubscriberDataObserver;
import com.taobao.config.client.SubscriberRegistrar;
import com.taobao.config.client.SubscriberRegistration;

import java.util.List;

/**
 * @author dou.guo
 * @version Subscriber, v 0.1 2022-09-08 4:48 下午 dou.guo Exp $
 */
public class MySubscriber {


    public static void main(String[] args) {
        // 数据订阅表
        // 订阅人的Id
        SubscriberRegistration subscriberRegistration = new SubscriberRegistration("kevin", "com.example.demo.framwork.hsf.service.HsfService:1.0.0");
        subscriberRegistration.setGroup("HSF");

        Subscriber subscriber = SubscriberRegistrar.register(subscriberRegistration);
        subscriber.setDataObserver(new SubscriberDataObserver() {
            @Override
            public void handleData(String dataId, List<Object> data) {
                System.out.println("收到dataId:" + dataId);
                System.out.println("数据:" + data);
                System.out.println("运行在:" + Thread.currentThread());
            }
        });
    }



}


