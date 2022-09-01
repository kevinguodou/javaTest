package com.example.demo.object;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author dou.guo
 * @version IntPair, v 0.1 2022-08-31 11:55 上午 dou.guo Exp $
 */
public class IntPair extends Pair<Integer>{

    public IntPair(Integer first, Integer second) {
        super(first, second);
    }

    public static void main(String[] args) {
        Class<IntPair> clazz = IntPair.class;
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }
    }
}
