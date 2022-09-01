package com.example.demo.framwork.spring.context;


import org.springframework.context.ApplicationEvent;

public class FoodEvent extends ApplicationEvent {
    public static final int BREAKFAST = 0;
    public static final int DINNER = 1;

    public FoodEvent(Object source, int t) {
        super(source);
        if (t < 0 || t > 1){
            t = 0;
        }
        type = t;
    }

    public void setType(int t) {
        type = t;
    }

    public int getType() {
        return type;
    }

    private int type;
}