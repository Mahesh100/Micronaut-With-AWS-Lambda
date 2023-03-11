package com.example.demo;


import jakarta.inject.Singleton;

@Singleton
public class MyService {

    public void sayHello(){
        System.out.println("Lambda is called for greeting");
    }

}
