package com.example.demo.string_array_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class convert_list_array {

    public static void main(String[] args) {

        ArrayList<String> sampleList = new ArrayList<>();

        sampleList.add("California");
        sampleList.add("Texas");
        sampleList.add("Illinois");
        sampleList.add("Massachusetts");
        sampleList.add("Florida");
        sampleList.add("Virginia");
        sampleList.add("Colorado");

        //todo : list -> array
        String[] arr = new String[sampleList.size()];
        sampleList.toArray(arr);
        System.out.println("arr:"+ Arrays.toString(arr));

        //todo : array -> list
        List<String> list;
        list = Arrays.asList(arr);
        System.out.println("list:"+ list);
    }
}
