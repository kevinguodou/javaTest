package com.example.demo.object;

import com.google.common.collect.Lists;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author dou.guo
 * @version MyCollections, v 0.1 2022-08-31 2:43 下午 dou.guo Exp $
 */
public class MyCollections {

    /**
     * 实现将list<integer>添加到list<number>
     */
    static void copy1(List<Number> dest, List<Integer> src){
        for (int i = 0;i<src.size();i++){
            dest.add(src.get(i));
        }
    }

    /**
     * 实现将list<child>添加到list<parent> 子类添加到父类中
     * 说明：参数签名限制了src一定是dest的子类
     */
    static <T> void copy(List<? super T> dest, List<? extends T> src){
        for (int i = 0;i<src.size();i++){
            //List<Integer> src ,即src.get的返回接受所有「T的子类」
            src.get(i);

            //dest.add接收所有T的子类，相当于T的引用指向「T的子类」的实体
            dest.add(src.get(i));
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Integer> src = Lists.newArrayList(3,4);
        List<Number> dest = Lists.newArrayList(1,2);

        MyCollections.copy(dest,src);
        System.out.println(dest);

        /*Class<String> clazz = String.class;
        String str = clazz.newInstance();*/

        /*Class<? super String> sup = String.class.getSuperclass();*/

        /*Class<Integer> clazz = Integer.class;
        Constructor<Integer> cons = clazz.getConstructor(int.class);
        Integer i = cons.newInstance(123);*/


        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;

        ps[0] = new Pair<String>("a", "b");
        arr[1] = new Pair<Integer>(1, 2);

        //这里编译器没有检查p的引用（string类型）能否指向ps[1]= Pair<Integer>
        Pair<String> p = ps[1];
        String s = p.getFirst();
    }

    /*无限定通配符*/
    static boolean isNull(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

}
