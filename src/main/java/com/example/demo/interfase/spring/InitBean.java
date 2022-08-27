package com.example.demo.interfase.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * @author dou.guo
 * @version InitBean, v 0.1 2022-08-25 2:36 下午 dou.guo Exp $
 */
@Component
public class InitBean implements InitializingBean, ApplicationContextAware {

    private int num;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("加载InitBean成功");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //实现了ApplicationContextAware接口的bean，spring会将容器传递过来
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("加载InitBean成功11");
        System.out.println(applicationContext.getApplicationName());
    }
}
