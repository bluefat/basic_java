package com.study.concurrent.thread;

import java.util.concurrent.Semaphore;

//信号量，用于多线程之间传递信号
public class StudySemaphore {

    private boolean signal = false;

    /**
     * 如果某线程在调用release等待之前调用take方法，那么
     * 调用release方法的线程仍然知道take方法已经被某个线程调用过了，因为
     * 该Semaphore内部保存了take方法发出的信号
     */
    public synchronized void take(){
        this.signal = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while ((!this.signal)){
            wait();
        }
        this.signal = false;
    }

    public static void main(String[] args){
        StudySemaphore studySemaphore = new StudySemaphore();

        Thread sendingThread = new Thread(new SendingThread(studySemaphore),"send");
        Thread recevingThread = new Thread(new RecevingThread(studySemaphore),"rece");

        sendingThread.start();
        recevingThread.start();

    }


    public static class SendingThread implements Runnable{
        StudySemaphore studySemaphore = null;

        public SendingThread(StudySemaphore studySemaphore){
            this.studySemaphore = studySemaphore;
        }

        @Override
        public void run() {
            while (true){
                System.out.println("开始释放");
                this.studySemaphore.take();
            }
        }
    }

    public static class RecevingThread implements Runnable{
        StudySemaphore studySemaphore = null;

        public RecevingThread(StudySemaphore studySemaphore){
            this.studySemaphore = studySemaphore;
        }
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("开始等待");
                    this.studySemaphore.release();
                }catch (InterruptedException in){
                    in.printStackTrace();
                }
            }
        }
    }
}
