package com.example.demo.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dou.guo
 * @version CollectionTest, v 0.1 2022-09-05 9:09 下午 dou.guo Exp $
 */
public class CollectionTest {

    private List<String> strList = new LinkedList<>();

    void iterator1(){
        //在链表数据结构下，用for循环效率比较低
        for (int i=0; i<strList.size(); i++) {
            String s = strList.get(i);
            System.out.println(s);
        }
    }

    void iterator2(){
        Iterator iterator = strList.iterator();
        //iterator迭代器对各种list的实现类都有实现其迭代的方式
        if (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //上面方法等同于for循环
        for (String str:strList){
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        //线程不安全
        Map<String,String> m1 = new HashMap(13);
        m1.put("name","kevin");
        m1.put("age","30");
        System.out.println(m1.get("name"));

        //线程安全
        Map<String,String> m2 = new ConcurrentHashMap<>(16);
        m2.put("name","cuiQian");
        m2.put("age","32");
        System.out.println(m2.get("name"));
    }


}
