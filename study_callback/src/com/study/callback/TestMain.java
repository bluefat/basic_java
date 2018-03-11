package com.study.callback;

public class TestMain {

    public static void main(String[] args){
        Student student = new Student();
        Teacher teacher = new Teacher(student);

        teacher.ask();
    }
}
