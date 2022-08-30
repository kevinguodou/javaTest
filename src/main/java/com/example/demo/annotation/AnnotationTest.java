package com.example.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.kevin.AnnotationExample;
import com.example.demo.annotation.kevin.kevin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


/**
 * @author dou.guo
 * @version AnnotationTest, v 0.1 2022-08-25 3:33 下午 dou.guo Exp $
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        String json = "{'a':1,'b':'2'}";
        Class bodyClass= Class.forName("java.util.Map");
        byte[] a=toBytes(JSON.parseObject(json,bodyClass));


        Object obj = getObjectFromBytes(a);
        Map<String, Object> mapResult = (Map) obj;
        Integer outOrderId = ((Integer) mapResult.get("a"));
        System.out.println(outOrderId);
        //isAnnotation(AnnotationExample.class,kevin.class);
    }

    public static byte[] toBytes(Object obj) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        bytes = bo.toByteArray();
        bo.close();
        oo.close();
        return bytes;
    }

    public static Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes == null || objBytes.length == 0) {
            return null;
        }
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }

    //判断类是否有某一注解
    public static boolean isAnnotation(Class<?> clzz,Class<? extends Annotation> ant) {
        try {
            //反射获取类，属性，方法
            if (clzz.isAnnotationPresent(ant)){
                System.out.println("类上注解");
                //return true;
            }


            Field[] fields=clzz.getFields();
            for (Field field:fields){
                if (field.isAnnotationPresent(ant)){
                    System.out.println(field.getAnnotation(kevin.class).value());
                    System.out.println("属性上注解"+field.getName());
                    //return true;
                }
            }

            Method[] methods = clzz.getMethods();
            for (Method method:methods){
                if (method.isAnnotationPresent(ant)){
                    System.out.println("方法上注解"+method.getName());
                    method.invoke(clzz.newInstance(),null);
                    //return true;
                }
            }
        }catch (Exception e){

        }
        return false;
    }
    //获取注解的值
}
