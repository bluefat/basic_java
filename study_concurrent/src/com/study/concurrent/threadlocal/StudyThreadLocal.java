package com.study.concurrent.threadlocal;

import java.util.Random;

public class StudyThreadLocal {
    public static class MyRunnable0 implements Runnable{
        private ThreadLocal<String> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set("hello" + Math.random());
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args){
        MyRunnable0 myRunnable0 =  new MyRunnable0();
        Thread thread0 = new Thread(myRunnable0,"thread_0");
        Thread thread1 = new Thread(myRunnable0,"thread_1");

        thread0.start();
        thread1.start();
    }



}
