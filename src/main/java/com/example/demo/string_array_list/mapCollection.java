package com.example.demo.string_array_list;

import lombok.Data;

import java.util.*;

public class mapCollection {

    @Data
    static class ObjectDto{
        private Integer id;
        private String code;
        private String name;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "hà nội");
        map.put(2, "thái bình");
        map.put(3, "hà nội");
        map.put(4, "hànội");
        map.replace(4, "hai duong");


        Set<Map.Entry<Integer, String>> set = map.entrySet();

        for(Map.Entry<Integer, String> i : set){
            System.out.println("key: "+ i.getKey()+ " -> "+ "value: "+ i.getValue());
        }
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("y");
        list.add("b");

        List<ObjectDto> objectDtos = new ArrayList<>();
        for(int i= 0; i <= 3; i++){
            ObjectDto objectDto = new ObjectDto();
            objectDto.setId(1);
            objectDto.setCode("code"+ i);
            objectDto.setName(list.get(i));

            objectDtos.add(objectDto);
        }
        objectDtos.forEach(element -> list1.add(element.getName()));
        System.out.println(list1);
    }
}
