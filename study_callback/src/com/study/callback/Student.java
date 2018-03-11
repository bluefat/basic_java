package com.study.callback;

public class Student {

    public void answer(final TeacherCallback teacherCallback){
//        teacherCallback.sendToTeacher("我不知道");

        new Thread(new Runnable() {
            @Override
            public void run() {
                teacherCallback.sendToTeacher("我不知道");
            }
        }).start();
    }
}
