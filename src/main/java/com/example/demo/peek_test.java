package com.example.demo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import lombok.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class peek_test {
    @Data
    public static class Auth{
        private Integer id;
        private String userName;
        private List<String> roles;
    }

    public static void main(String[] args) {
        List<String> oks = Arrays.asList(new String("deptrai"), new String("vippro"), new String("nhuvip"));
//        oks.stream().map(String::toUpperCase).forEach(System.out::println);
//
//        oks.stream().peek(s -> s = s.toUpperCase()).forEach(System.out::println);

        oks.stream().filter(ok -> ok.contains("n")).forEach(System.out::println);

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


        Stream<String> userStream = Stream.of(new String("Alice"), new String("Bob"), new String("Chuck"));
        userStream.peek(u -> System.out.println(u.toLowerCase()))
                .collect(Collectors.toList());

        Stream<String> userStream1 = Stream.of(new String("Alice"), new String("Bob"), new String("Chuck"));
        userStream1.map(String::toLowerCase).forEach(System.out::println);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setMinimalDaysInFirstWeek(7);
        calendar.setTime(date);
        System.out.println(calendar);
        System.out.println( calendar.get(Calendar.DAY_OF_WEEK) + "-" + calendar.get(Calendar.DAY_OF_MONTH));


        LocalDate localDate = LocalDate.now();
        System.out.println("ok : " + localDate);

        Algorithm algorithm = Algorithm.HMAC512("xxxxxxxxxxxxxxxxx");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2RhdGEiOiJ7XCJpZFwiOjg2NixcInVzZXJOYW1lXCI6XCJnaWxsZVwiLFwicm9sZXNcIjpbXCJBUlRJU1RcIl19IiwiZXhwIjoxNzAyOTc0NjQxfQ.5oQScCs7jGgGa5dQqe9MHtJ-hkwpsGXYqOWdl-tfZLmcOboVbf6QJnP6_2eg2hCcn-7j7pgtHJnToxfPByHtHA");
        System.out.println(decodedJWT.getExpiresAt());


        Auth auth = new Auth();
        auth.setId(361);
        auth.setUserName("karik");
        auth.setRoles(Collections.singletonList("ARTIST"));

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar1.add(Calendar.MONTH, 12);
        Algorithm algorithm1 = Algorithm.HMAC512("xxxxxxxxxxxxxxxxx");
        System.out.println(JWT.create()
                .withExpiresAt(calendar1.getTime())
                .withClaim("user_data", new Gson().toJson(auth))
                .sign(algorithm1));


        String ok = new Gson().toJson(auth);
        System.out.println("auth : "+ auth);
        System.out.println("ok : " + ok);




    }
}
