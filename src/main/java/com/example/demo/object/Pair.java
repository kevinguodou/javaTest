package com.example.demo.object;

/**
 * @author dou.guo
 * @version Pair, v 0.1 2022-08-31 11:36 上午 dou.guo Exp $
 */
public class Pair<T> {
    
    private T first;
    
    private T second;

    //不能实例化T
    /*public Pair() {
        this.first = new T();
        this.second = new T();
    }*/

    /*public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        this.first = clazz.newInstance();
        this.second = clazz.newInstance();
    }*/

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /*public boolean equals(T t) {
        return this == t;
    }*/

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        //编译器会把T视作Object处理，虚拟机里加载的就是object，所以不能传入基本类型，只能传入引用类型
        /*new Pair<int>();*/

        //虚拟机里加载的就是object，所以是同一个class
        /*Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1==c2);
        System.out.println(c1==Pair.class);*/

    }

}
