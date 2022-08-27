package com.example.demo.servicApi;

/**
 * @author dou.guo
 * @version RemoteService, v 0.1 2022-08-25 3:58 下午 dou.guo Exp $
 */
public class RemoteService {

    private String serviceTag;

    public void oprate(){
        System.out.println(serviceTag);
    };

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

}
