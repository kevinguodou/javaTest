package com.example.demo.annotation.spring;

import com.example.demo.SpringContextUtil;
import com.example.demo.annotation.kevin.kevin;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author dou.guo
 * @version ReverseMessageTestServiceImpl, v 0.1 2022-08-30 10:21 上午 dou.guo Exp $
 */
public class ReverseMessageTestService {

    private final static String PACKAGE_PREFIX = "com.example.demo.annotation";


    public void kevinAnnotatedTest(String className) {
        Reflections reflection = new Reflections(PACKAGE_PREFIX);
        work(className, reflection);
    }

    private void work(String className, Reflections reflection) {
        try {
            //通过标注过滤出所有类
            Set<Class<?>> classes = reflection.getTypesAnnotatedWith(kevin.class);

            //通过类名定位具体的类
            Class<?> targetCls = null;
            for (Class clazz : classes) {
                if (clazz.getName().equals(className)) {
                    targetCls = clazz;
                    break;
                }
            }
            if (targetCls == null) {
                return;
            }

            //通过类的invock方法调用
            Method method = targetCls.getMethod("printParam", String.class);
            Object object =SpringContextUtil.getBean(targetCls.getSimpleName().substring(0,1).toLowerCase()+targetCls.getSimpleName().substring(1));
            method.invoke(object, "guodou");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
