package com.example.demo.framwork.spring;

import java.util.List;

public interface IOwner {
    void setName(String name);

    String getName();

    void setPets(List pets);

    List getPets();
}