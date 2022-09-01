package com.example.demo.framwork.spring;


import com.example.demo.framwork.spring.context.FoodEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Pet implements IPet , ApplicationListener {

    public Pet() {
    }

    public Pet(String name, int age, ISpecies sp) {
        this.name = name;
        this.age = age;
        species = sp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(ISpecies sp) {
        species = sp;
    }

    public ISpecies getSpecies() {
        return species;
    }

    private String name;
    private int age;
    private ISpecies species;

    @Override
    public void onApplicationEvent(ApplicationEvent e) {
        if (e instanceof FoodEvent) {
            FoodEvent ev = (FoodEvent) e;
            Owner owner = (Owner) ev.getSource();
            String name = owner.getName();
            switch(ev.getType()) {
                case FoodEvent.BREAKFAST:
                    System.out.println("Hurrah, " + name +
                            " says it’s breakfast time");
                    break;
                case FoodEvent.DINNER:
                    System.out.println("Hurrah, " + name +
                            " says it’s dinner time");
                    break;
            }
        }
    }
}