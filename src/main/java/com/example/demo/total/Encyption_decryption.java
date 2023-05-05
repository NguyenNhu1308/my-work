package com.example.demo.total;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Encyption_decryption {

    public static void main(String[] args) {
                Algorithm algorithm = Algorithm.HMAC512("xxxxxxxxxxxxxxxxx");
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2RhdGEiOiJ7XCJpZFwiOjg2NixcInVzZXJOYW1lXCI6XCJnaWxsZVwiLFwicm9sZXNcIjpbXCJBUlRJU1RcIl19IiwiZXhwIjoxNzAyOTc0NjQxfQ.5oQScCs7jGgGa5dQqe9MHtJ-hkwpsGXYqOWdl-tfZLmcOboVbf6QJnP6_2eg2hCcn-7j7pgtHJnToxfPByHtHA");
        System.out.println(decodedJWT.getExpiresAt());


        peek_filter_map.Auth auth = new peek_filter_map.Auth();
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
