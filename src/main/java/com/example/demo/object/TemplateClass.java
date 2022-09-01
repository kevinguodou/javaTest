package com.example.demo.object;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author dou.guo
 * @version TemplateClass, v 0.1 2022-08-31 10:38 上午 dou.guo Exp $
 */
public class TemplateClass {

    public static void main(String[] args) {
        //1，object类型，添加元素的时候允许元素的类型不一样
        ArrayList strings = new ArrayList<>();
        strings.add("q");
        strings.add(1);

        //取得时候需要强制转换类型，可能类型转换失败
        String a = (String) strings.get(0);
        String c = (String) strings.get(1);

        //2，模版类型，添加元素的时候元素的类型必须一致
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        Integer integer = ints.get(1);

        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
    }

}
