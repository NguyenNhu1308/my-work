package com.example.demo.total;

public class supper {

    static class animal{
        public String action;

        public animal(String action){
            super();
            this.action = action;
        }

        public void oke(String name){
            System.out.println("animal");
            System.out.println(name);
        }
    }

    static class dog extends animal{
        public String action = "gau gau";

        public dog(String action){
            super(action);
        }


        public void display(){
            System.out.println("dog: "+ action);
            System.out.println("animal: "+ super.action);

            super.oke("animal");

        }
    }
    public static void main(String[] args) {
        dog dog = new dog("deptrai");
        dog.display();
    }
}

