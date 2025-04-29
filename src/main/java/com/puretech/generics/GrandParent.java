package com.puretech.generics;

import java.util.List;

public class GrandParent <T>{
    public <T> T process(T t){
        return t;
    }

    <T extends Comparable<? super T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static <T extends Animal> T getFirst(List<T> list, T item){

         list.add(item);
         return item;
    }
}
