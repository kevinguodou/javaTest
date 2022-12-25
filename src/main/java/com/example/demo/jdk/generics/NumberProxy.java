package com.example.demo.jdk.generics;

/**
 * @author dou.guo
 * @version NumberProxy, v 0.1 2022-10-11 10:45 上午 dou.guo Exp $
 */
public class NumberProxy<T> {

    private T first;

    private T second;

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


}
