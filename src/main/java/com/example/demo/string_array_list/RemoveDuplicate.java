package com.example.demo.string_array_list;

import java.util.*;

public class RemoveDuplicate {

    public static void main(String[] args) {

        String a = "Ca sĩ, Ca sĩ, Nhà sản xuất âm nhạc, Nhà sản xuất âm nhạc, Nhạc sĩ, Nhạc sĩ";
        String[] list = a.split(",");

        Set<String> set = new HashSet<>();
        for(String it : a.split(",")){
            set.add(it.trim());
        }
        List<String> list1 = new ArrayList<>(set);
        String ok = String.join(",", list1);
        System.out.println(ok);
    }
}
