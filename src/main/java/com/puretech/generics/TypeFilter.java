package com.puretech.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TypeFilter {

    public static <T> List<T> filterByType(List<?> list, Class<T> type) {
        List<T> result = new ArrayList<>();
        for (Object item : list) {
            if (type.isInstance(item)) {
                result.add(type.cast(item));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Object> mixed = Arrays.asList("apple", 42, 3.14, "banana", true);

        List<String> strings = filterByType(mixed, String.class);
        List<Integer> integers = filterByType(mixed, Integer.class);
        List<Double> doubles = filterByType(mixed, Double.class);

        System.out.println("Strings: " + strings);   // [apple, banana]
        System.out.println("Integers: " + integers); // [42]
        System.out.println("Doubles: " + doubles);   // [3.14]
    }
}