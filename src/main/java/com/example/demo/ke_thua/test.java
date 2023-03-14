package com.example.demo.ke_thua;


abstract class okee {
    protected void executeCmd() {
    }
    public void execute() {
    }
}

class base extends okee {
    public void execute() {
        executeCmd();
    }
}


class Animal extends base {
    public String run;
    public String eat;
    public String call;
}

class Dog extends Animal {
    protected void executeCmd() {
        System.out.println("run:" + run);
        System.out.println("eat:" + eat);
        System.out.println("call:" + call);
    }
}

class Cat extends Animal {
    protected void executeCmd() {
        System.out.println("meo meo");
    }
}

class Pig extends Animal {
        protected void executeCmd() {
            System.out.println("dog:");
            System.out.println("run " + run + ", eat " + eat + ", call " + call);
        }

}


public class test {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.execute();

        Dog dog = new Dog();
        dog.run = "so fast";
        dog.eat = "fast";
        dog.call = "gâu gâu";
        dog.execute();

        Pig pig = new Pig();
        pig.run = "fast";
        pig.eat = "slow";
        pig.call = "éc éc";
        pig.executeCmd();
    }
}
