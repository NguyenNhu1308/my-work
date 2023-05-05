package com.example.demo.total;

import java.util.ArrayList;
import java.util.List;

public class newTest {

    public static void main(String[] args) {

        peek_filter_map.Auth auth = new peek_filter_map.Auth(1, "nhunguyen", new ArrayList<>());
        peek_filter_map.Auth auth2 = new peek_filter_map.Auth(2, "nhunguyen2", new ArrayList<>());
        List<peek_filter_map.Auth> auths = new ArrayList<>();
        auths.add(auth);
        auths.add(auth2);

        System.out.println("auth:"+ auths);
        auths.forEach(auth1 -> auth1.setId(3));
        System.out.println("auth1:"+ auths);
    }
}
