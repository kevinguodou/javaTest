package com.example.demo.framwork.spring;


import com.example.demo.framwork.spring.context.FoodEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;

import java.util.ArrayList;
import java.util.List;

public class Owner implements IOwner , ApplicationContextAware {

    private ApplicationContext ctx;
    private String name;
    private ArrayList pets = new ArrayList();

    public Owner() {
    }

    public Owner(String name, List pets) {
        this.name = name;
        setPets(pets);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPets(List pets) {
        this.pets.clear();
        this.pets.addAll(pets);
    }

    public List getPets() {
        return pets;
    }

    public void feedPets() {
        double d = Math.random();
        FoodEvent ev = new FoodEvent(this, d < 0.5 ? FoodEvent.BREAKFAST : FoodEvent.DINNER);
        ctx.publishEvent(ev);
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws ApplicationContextException {
        this.ctx = ctx;
    }
}