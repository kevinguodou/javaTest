package com.example.demo.annotation.kevin;

/**
 * @author dou.guo
 * @version AnnotationExample, v 0.1 2022-08-27 10:43 上午 dou.guo Exp $
 */
@kevin("class annotation")
public class AnnotationExample {

    @kevin("field annotation")
    public int a = 3;

    public String b = "";

    @kevin("methord annotation")
    public void operation1(){
        System.out.println("operation1");
    }

    public void operation2(){
        System.out.println("operation2");
    }
}
