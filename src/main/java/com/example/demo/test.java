package com.example.demo;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        String a = "5";
        String b = "1.5";

        double a1 = Double.parseDouble(a);
        double b1 = Double.parseDouble(b);
        double c1 = 5;
        double c = 3.8;
        double d =  (a1 + b1 + c1)/3;
        double d1 =(2*c + c1)/3;
        System.out.println(c);
        System.out.println((double) Math.round(c * 10) / 10);
        System.out.println(d);
        System.out.println((double) Math.round(d * 10) / 10);
        System.out.println(d1);

        double x = (double) Math.round(4.745634463 * 10) / 10;
        System.out.println("x:" + x);

        Scanner input = new Scanner(System.in);
        double test = input.nextDouble();
        double origin = Double.parseDouble(String.valueOf(test).substring(0, String.valueOf(test).indexOf(".")));
        double between = origin + 0.5;
        double end = origin +1;

        System.out.println("origin :" + origin);
        System.out.println("between :" + between);
        System.out.println("end :" + end);

        double point ;

        if(test < origin + 0.3){
            point = origin;
        }
         else if(test >= origin + 0.3 && test < between+ 0.3){
            point = between;
        }
        else{
            point = end;
        }

        System.out.println("point:" + point);
    }

}
