package com.example.demo.framwork.hsf;

import com.taobao.hsf.app.api.util.HSFApiProviderBean;
import com.taobao.hsf.app.spring.util.annotation.HSFProvider;
import com.taobao.hsf.util.HSFServiceContainer;

/**
 * @author dou.guo
 * @version HsfProvider, v 0.1 2022-08-22 4:37 下午 dou.guo Exp $
 */
public class HsfProvider {

    public static void main(String[] args) throws Exception {
        HSFApiProviderBean hSFApiProviderBean = new HSFApiProviderBean();
        hSFApiProviderBean.setClientTimeout(3000);
        hSFApiProviderBean.init();
    }

}
