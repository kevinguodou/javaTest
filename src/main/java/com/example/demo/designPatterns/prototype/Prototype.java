package com.example.demo.designPatterns.prototype;

import org.springframework.util.Assert;

/**
 * @author dou.guo
 * @version Prototype, v 0.1 2022-10-13 3:40 下午 dou.guo Exp $
 */
public class Prototype implements Cloneable{

    private String a;
    private String b;

    public Prototype(String a, String b) {
        this.a = a;
        this.b = b;
    }

    /**
     * 自己复制自己
     * @return
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype a = new Prototype("guo","dou");
        Prototype b = (Prototype) a.clone();
        Assert.isTrue(b.a.equals("guoq"),"ok");
    }

}
