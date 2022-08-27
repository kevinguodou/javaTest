package com.example.demo.annotation.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author dou.guo
 * @version ServiceClzz, v 0.1 2022-08-25 3:37 下午 dou.guo Exp $
 */
@Service
public class ServiceClzz {

    @Autowired
    private ComponentClzz componentClzz;

    public void operate(){
        componentClzz.print();
    }

}
