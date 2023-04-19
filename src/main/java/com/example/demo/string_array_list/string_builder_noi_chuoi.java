package com.example.demo.string_array_list;

public class string_builder_noi_chuoi {

    public static void main(String[] args) {

        String name;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i).append(",");
        }
        name = stringBuilder.toString();
        name = name.substring(0, name.length() - 1);
        System.out.println("name:" + name);

    }
}
