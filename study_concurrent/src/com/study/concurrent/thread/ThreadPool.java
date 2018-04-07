package com.study.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStoped = false;

    public ThreadPool(int noOfThreads,int maxNoOfThreads){
        taskQueue  = new ArrayBlockingQueue(maxNoOfThreads);
        for (int i = 0;i < noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void execute(Thread thread) throws InterruptedException{
        if(this.isStoped){
            throw new IllegalStateException("ThreadPool is stoped");
        }
        this.taskQueue.take();
    }

    public synchronized boolean stop(){
        this.isStoped = true;
        for (PoolThread thread : threads){
            thread.toStop();
        }
        return this.isStoped;
    }


    public class PoolThread extends Thread{
        private BlockingQueue<Thread> taskQueue = null;
        private boolean isStoped = false;

        public PoolThread(BlockingQueue<Thread> queue){
            this.taskQueue = queue;
        }

        @Override
        public void run() {
            while (!isStoped){
                try {
                    Thread thread = taskQueue.take();
                    thread.run();
                }catch (InterruptedException inte){
                    inte.printStackTrace();
                }
            }
        }

        public synchronized void toStop(){
            this.isStoped = true;
            this.interrupt();
        }

        public synchronized boolean isStoped(){
            return this.isStoped;
        }
    }
}
