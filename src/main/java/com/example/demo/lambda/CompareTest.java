package com.example.demo.lambda;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dou.guo
 * @version CompareTest, v 0.1 2022-08-30 8:18 下午 dou.guo Exp $
 */
public class CompareTest {

    //参考文章：https://www.liaoxuefeng.com/wiki/1252599548343744/1305207799545890
    public static void main(String[] args) {
        baseClassCompare();
        baseLambdaCompare();
        baseLambda1Compare();
    }

   public static void  baseClassCompare(){
        String[] array = {"apple","code","people"};
        //注意第二个入参是一个class的实例
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(array.toString());
    }

    public static void  baseLambdaCompare(){
        String[] array = {"apple","people","code"};
        //注意第二个入参没有class的实例，只要入参为@FunctionalInterface都可以这么用
        Arrays.sort(array, (o1,o2)->o1.compareTo(o2));
        System.out.println(array.toString());
    }

    public static void  baseLambda1Compare(){
        String[] array = {"apple","people","code"};
        //注意第二个入参没有class的实例，只要传入方法签名即可
        Arrays.sort(array, String::compareTo);
        System.out.println(array.toString());

        //真正灵活的地方，都不需要继承接口，只需要方法签名即可
        List<String> names = Lists.newArrayList("Bob", "Alice", "Tim");
        List<Person> a = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(a);
    }
}


