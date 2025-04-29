package com.puretech.generics;

class Parent<T> extends GrandParent<T>{
    public static void main(String[] args) {
        GrandParent<String> gp = new GrandParent<>();
        System.out.println(gp.process("Hello"));

        GrandParent<String> gp1 = new GrandParent<>();
        System.out.println(gp1.process(1));

    }
}
