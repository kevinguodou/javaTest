package com.example.demo.object;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairHelper {


    public static void main(String[] args) {

        //实际的入参是double类型，入参可以是Number的继承类
       int sum1 = PairHelper.add(new Pair<Number>(1.1,2.2));
       System.out.println(sum1);

       Pair<Integer> integerPair = new Pair<>(1, 3);
       int sum2 = PairHelper.add(integerPair);
       System.out.println(sum2);

        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getSecond());
        System.out.println(p2.getFirst() + ", " + p2.getSecond());
    }

    /*static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getSecond();
        return first.intValue() + last.intValue();
    }*/

    //<? extends Number>上界通配符,
    // 只能读值，不能赋值
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getSecond();
        return first.intValue() + last.intValue();
    }

    //可以赋值
    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setSecond(n);

        //程序也不知道<? super Integer>的父类有哪些，强制类型转换可能会报错
        /*String a =  (String)p.getFirst();*/
        Object a =  p.getFirst();
    }

}