package com.example.demo.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dou.guo
 * @version CompareTest, v 0.1 2022-08-30 8:18 下午 dou.guo Exp $
 */
public class CompareTest {

    public static void main(String[] args) {
        baseClassCompare();
        baseLambdaCompare();
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

}
