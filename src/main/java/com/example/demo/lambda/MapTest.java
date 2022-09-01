package com.example.demo.lambda;

import com.sun.tools.javac.util.List;

/**
 * @author dou.guo
 * @version MapTest, v 0.1 2022-08-30 9:53 下午 dou.guo Exp $
 */
public class MapTest {

    //map()方法用于将一个Stream的每个元素映射成另一个元素并转换成一个新的Stream
    public static void main(String[] args) {
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream()
                .map(String::trim) // 去空格
                .map(String::toLowerCase) // 变小写
                .forEach(System.out::println); // 打印
    }

}
