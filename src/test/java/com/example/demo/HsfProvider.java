package com.example.demo;

import com.example.demo.framwork.hsf.service.HsfService;
import com.taobao.hsf.app.api.util.HSFApiProviderBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author dou.guo
 * @version HsfProvider, v 0.1 2022-08-22 4:37 下午 dou.guo Exp $
 */
@SpringBootTest
public class HsfProvider {

    @Resource
    HsfService hsfService;

    @Test
    void main() throws Exception {
        HSFApiProviderBean hSFApiProviderBean = new HSFApiProviderBean();
        hSFApiProviderBean.setTarget(hsfService);
        hSFApiProviderBean.setServiceVersion("1.0.0");
        hSFApiProviderBean.setClientTimeout(3000);
        hSFApiProviderBean.setServiceGroup("HSF");
        hSFApiProviderBean.setPreferSerializeType("hessian2");
        hSFApiProviderBean.init();
    }

}
