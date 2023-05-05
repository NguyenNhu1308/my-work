package com.example.demo.total;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class peek_filter_map {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Auth{
        private Integer id;
        private String userName;
        private List<String> roles;
    }

    public static void main(String[] args) {
        List<String> oks = Arrays.asList(new String("deptrai"), new String("vippro"), new String("nhuvip"));

        oks.stream().map(String::toUpperCase).forEach(System.out::println);
        oks.stream().peek(s -> s = s.toUpperCase()).forEach(System.out::println);

        Auth auth = new Auth(1, "nhunguyen", new ArrayList<>());
        Auth auth2 = new Auth(2, "nhunguyen2", new ArrayList<>());
        List<Auth> auths = new ArrayList<>();
        auths.add(auth);
        auths.add(auth2);


        List<Auth> filter = new ArrayList<>();
        List<String> map = new ArrayList<>();
        List<Auth> map1 = new ArrayList<>();
        List<Auth> peek = new ArrayList<>();

        filter = auths.stream().filter(element -> element.getId().equals(1)).collect(Collectors.toList());
        System.out.println("filter:"+ filter);

        map = auths.stream().map(element -> element.getUserName().substring(0,2)).collect(Collectors.toList());
        System.out.println("map:"+ map);

        List<String> finalMap = map;
        map1 = auths.stream().map(element -> {
            Auth auth1 = new Auth();
            auth1.setId(1);
            auth1.setRoles(finalMap);
            auth1.setUserName(element.getUserName().concat("1"));
            return auth1;
        }).collect(Collectors.toList());

        map1 = auths.stream().peek(element -> {
            element.setId(1);
            element.setRoles(finalMap);
            element.setUserName(element.getUserName().concat("1"));
        }).collect(Collectors.toList());



        peek = auths.stream().peek(element -> element.setRoles(finalMap)).collect(Collectors.toList());
        System.out.println("peek:" + peek);



        oks.stream().map(ok -> ok.contains("n")).forEach(System.out::println);

        oks.stream()
                .filter(ok -> ok.contains("i"))
                .peek(ok -> System.out.println("ok:" + ok))
                .collect(Collectors.toList());

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }
}
