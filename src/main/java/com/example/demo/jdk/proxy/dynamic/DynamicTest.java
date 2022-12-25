package com.example.demo.jdk.proxy.dynamic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author dou.guo
 * @version DynamicTest, v 0.1 2022-09-29 11:40 上午 dou.guo Exp $
 */
public class DynamicTest {

    public static void main(String[] args) {

        Object mapper = MapperProxy.getMapper(PersonMapper.class);
        Class<?> aClass = mapper.getClass();
         Method[] methods = aClass.getMethods();
        Field[] fields = aClass.getFields();

        PersonMapper personMapper = (PersonMapper)MapperProxy.getMapper(PersonMapper.class);
        personMapper.eat();

        PetMapper petMapper = null;
        petMapper.rest();
    }

}
