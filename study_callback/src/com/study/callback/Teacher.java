package com.study.callback;

public class Teacher implements TeacherCallback{

    private Student student;

    public Teacher(Student student){
        this.student = student;
    }

    public void ask(){
        System.out.println("你知不知道康师傅方便面?");
        student.answer(this);
        System.out.println("老师又问其他同学去了");
    }

    @Override
    public void sendToTeacher(Object object) {
        System.out.println("明白了，确认是：" + object);
    }
}
