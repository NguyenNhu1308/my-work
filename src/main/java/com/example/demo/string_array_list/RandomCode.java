package com.example.demo.string_array_list;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCode {

    private static Random generator = new Random();

    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static final String ALL = alpha + alphaUpperCase + digits + specials;


    //random hai ký tự hoa
    public String randomUpperCase(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, alphaUpperCase.length() - 1);
            char ch = alphaUpperCase.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    //radom số từ một đến 99
    int ranNum = ThreadLocalRandom.current().nextInt(10,100);
    int ranNum1 = ThreadLocalRandom.current().nextInt(10,100);

    //radom chuỗi số có 6 chữ số
    public int randomCode() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
    }

    //todo : code tự sinh mã khách hàng, mã nghệ sĩ, mã đơn vị quản lý
    public String codeRandom(String name){

        String code0 = StringUtils.unicode2ASII(name).replaceAll("[.() ]", "");
        if(code0.length() == 1){
            code0 = code0.concat(code0);
        }

        return StringUtils.stripAccents(code0.substring(0, 2).toUpperCase().concat(String.valueOf(randomCode())));
    }

    public static void main(String[] args) {

            RandomCode randomCode = new RandomCode();

            int numberOfCharactor = 2;

            String code = randomCode.randomUpperCase(numberOfCharactor) + randomCode.ranNum + randomCode.ranNum1;
            System.out.println(code);

        System.out.println("ma khach hang:"+ randomCode.codeRandom("xuannhu"));
    }
}
