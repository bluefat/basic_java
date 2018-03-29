package com.study.concurrent;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args){
        threadExample();
    }

    public static void test(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable , "helloworld");
        thread.start();
        System.out.println("name:" + thread.getName());
        System.out.println("引用：" +thread.currentThread().getName());
    }

    public static void threadExample(){
        System.out.println(Thread.currentThread().getName());
        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }
    }

}
