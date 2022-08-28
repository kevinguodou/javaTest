package com.example.demo.framwork.hsf.service;

/**
 * @author dou.guo
 * @version HsfServiceImpl, v 0.1 2022-08-25 5:15 下午 dou.guo Exp $
 */


import org.springframework.stereotype.Service;

/*@HSFProvider(serviceInterface = HsfProvider.class, clientTimeout = 3000)*/
@Service
public class HsfServiceImpl {

    public int operate(String req) {
        return 888;
    }
}
