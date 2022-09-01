package com.example.demo.lambda;

class Person{
        public String name;
        public Person(String name){
            this.name = name;
        }
        @Override
        public String toString() {
            return "Person:" + this.name;
        }
    }