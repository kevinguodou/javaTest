package com.example.demo.framwork.spring;

import com.example.demo.framwork.spring.context.FoodEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Species implements ISpecies , ApplicationListener {

    private String name;

    public Species() {
    }

    public Species(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        if (e instanceof FoodEvent) {
            FoodEvent ev = (FoodEvent) e;
            Owner owner = (Owner) ev.getSource();
            String name = owner.getName();
            switch(ev.getType()) {
                case FoodEvent.BREAKFAST:
                    System.out.println("kevin, " + name +
                            " says it’s breakfast time");
                    break;
                case FoodEvent.DINNER:
                    System.out.println("kevin, " + name +
                            " says it’s dinner time");
                    break;
            }
        }
    }
}