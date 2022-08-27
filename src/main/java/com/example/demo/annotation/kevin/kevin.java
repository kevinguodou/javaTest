package com.example.demo.annotation.kevin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author dou.guo
 * @version kevin, v 0.1 2022-08-27 10:21 上午 dou.guo Exp $
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface kevin {

    String value() default "自定义注释";

}
