package com.lobin.rpc;

public class HelloServiceImpl implements HelloService {
 
    public String sayHi(String name) {
        return "Hi, " + name;
    }
 
}