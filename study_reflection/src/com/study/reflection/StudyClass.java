package com.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class StudyClass {

    public static void main(String[] args){
        try {
            Constructor constructor = User.class.getConstructor();
            User user = (User)constructor.newInstance();
            user.setPassword("ddd");
        }catch (Exception e){
            e.printStackTrace();
        }
//        testForClass();
    }

    public static void testForClass(){
        try {
            Class user = Class.forName("com.study.reflection.User");
            Method[] methods = user.getMethods();
            for (Method method: methods) {
                System.out.println(method.getName());
            }

        }catch (ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
    }
}
