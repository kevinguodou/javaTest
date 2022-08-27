package com.example.demo;

import com.example.demo.servicApi.RemoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dou.guo
 * @version ServiceApiConfig, v 0.1 2022-08-25 4:04 下午 dou.guo Exp $
 */
@Configuration
public class ServiceApiConfig {

    @Bean
    public RemoteService initRemoteServiceBean(){
        RemoteService remoteService = new RemoteService();
        remoteService.setServiceTag("RemoteService");
        return remoteService;
    }
}
