package com.example.demo.framwork.hsf.configserver;

import com.taobao.config.client.PublisherRegistrar;
import com.taobao.config.client.PublisherRegistration;

import java.util.Scanner;

/**
 * @author dou.guo
 * @version Publisher, v 0.1 2022-09-08 4:48 下午 dou.guo Exp $
 */
public class Publisher {

    public static void main(String[] args) {
        PublisherRegistration<String> registration = new PublisherRegistration<>("kevin", "com.example.demo.framwork.hsf.service.HsfService:1.0.0");
        registration.setGroup("HSF");

        com.taobao.config.client.Publisher<String> register = PublisherRegistrar.register(registration);

        Scanner scanner = new Scanner(System.in);
        while (scanner.nextLine()!=null){
            register.publish(scanner.nextLine());
        }

        System.exit(1);
    }

}
