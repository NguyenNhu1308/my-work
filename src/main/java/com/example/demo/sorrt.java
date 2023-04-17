package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class sorrt {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(5);
//        list.add(8);
//        list.add(9);
//        list.add(1);
//        list.add(0);
        System.out.println("before:" +list);
        List<Integer> list1 = list.stream().sorted().collect(Collectors.toList());
if(list1.size()>=1) {
    System.out.println(list1.get(list1.size() - 1));
}

    }
}
