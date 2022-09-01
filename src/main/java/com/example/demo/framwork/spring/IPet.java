package com.example.demo.framwork.spring;

public interface IPet {
    void setName(String name);

    String getName();

    int getAge();

    void setAge(int age);

    void setSpecies(ISpecies sp);

    ISpecies getSpecies();
}