package com.study.concurrent.thread;

public class MyThread {

    MyThreadObjectLock myThreadObjectLock = new MyThreadObjectLock();

    int i = 0;

    public void add(){
        synchronized (myThreadObjectLock){
            while (true){
                try {
                    if(i > 10){
                        System.out.println("add wait");
                        //释放
                        myThreadObjectLock.notify();
                        //当前线程进入等待
                        myThreadObjectLock.wait();
                    }else {
                        System.out.println("add +1");
                        i++;
                        System.out.println(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
    }


    public void delete(){
        synchronized (myThreadObjectLock){
            while (true){
                try {
                    if(i < 5){
                        System.out.println("delete wait");
                        //释放
                        myThreadObjectLock.notify();
                        //当前线程进入等待
                        myThreadObjectLock.wait();
                    }else {
                        System.out.println("delete -1");
                        i--;
                        System.out.println(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.add();
            }
        },"thread_add").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myThread.delete();
            }
        },"thread_delete").start();


    }
}
