package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentBuilderPattern {

    private String name;
    private Integer age;
    private String address;
    private String school;


    public void showInfo(){
        System.out.println("name :"+ name);
        System.out.println("age :"+ age);
        System.out.println("address :"+ address);
        System.out.println("school :"+ school +"\n");
    }

    @NoArgsConstructor
    public static class BuilderPattern{
        String name;
        Integer age;
        String address;
        String school;

        public static BuilderPattern builder(){
            return new BuilderPattern();
        }
        public BuilderPattern buildName(String name){
            this.name = name;
            return this;
        }
        public BuilderPattern buildAge(Integer age){
            this.age = age;
            return this;
        }
        public BuilderPattern buildAddress(String address){
            this.address = address;
            return this;
        }
        public BuilderPattern buildSchool(String school){
            this.school = school;
            return this;
        }
        public StudentBuilderPattern build(){
            return new StudentBuilderPattern(name, age, address, school);
        }
    }


    public static void main(String[] args) {

        //contructor
        StudentBuilderPattern student = new StudentBuilderPattern("Nhu", 24, "Thai Binh", "Dai hoc bon ba");
        student.showInfo();


        //builderPattern
        StudentBuilderPattern student1 = BuilderPattern.builder()
                .buildName("Huy")
                .buildAge(34)
                .buildAddress("Ha noi")
                .buildSchool("Dai hoc chem gio")
                .build();
        System.out.println(student1.toString());

        StudentBuilderPattern student2 = BuilderPattern.builder()
                .buildName("Nam")
                .buildAge(12)
                .build();
        System.out.println(student2.toString());

        Optional<StudentBuilderPattern> studentBuilderPattern = Optional.ofNullable(student2);
        studentBuilderPattern.ifPresent(studentBuilderPattern1 -> System.out.println(studentBuilderPattern1.getAge()));

    }
}
