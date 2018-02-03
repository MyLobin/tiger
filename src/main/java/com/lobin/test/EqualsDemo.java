package com.lobin.test;

public class EqualsDemo {
    public static void main(String[] args) {
        Object o2=null;
        Object o1="test";
        print(o1==o2);
        print(o1.equals(o2));

        String s1="s";
        String s2="s";
        String s3=new String("s");
        print(s1==s2);
        print(s1.equals(s2));
        print(s1==s3);
        print(s1.equals(s3));
    }


    public static void print(Object o){
        System.out.println(o);
    }
}
