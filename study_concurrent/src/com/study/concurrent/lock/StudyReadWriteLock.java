package com.study.concurrent.lock;

import java.util.HashMap;
import java.util.Map;

public class StudyReadWriteLock {

    //读操作
//    private int readers = 0;
    //写操作
//    private int writers = 0;
    //读请求
    private int writeRequests = 0;
    //获取写锁的次数
    private int writeAccesses = 0;

    private Thread writeThread = null;

    //为满足读锁重入，声明一个map来进行对线程是否持有锁的存储
    private Map<Thread,Integer> readingThreads = new HashMap<Thread,Integer>();

    public synchronized void lockRead() throws InterruptedException{
        //为满足读锁重入需要获取当前线程
        Thread callingThread = Thread.currentThread();
        //判断线程是否可以获取读锁，如果有则跳过循环
        while (!canGrantRead(callingThread)){
            wait();
        }
        //当一个线程试图获取读锁时判断 如果有写请求或写操作就将当前线程等待
//        while (writers > 0 || writeRequests > 0){
//            wait();
//        }
        //没有写操作或写请求就把读操作次数递增
//        readers++;

        readingThreads.put(callingThread,(null == readingThreads.get(callingThread) ? 0 : readingThreads.get(callingThread)) + 1);
    }

    public synchronized void unlockRead(){
//        readers--;
        Thread callingThread = Thread.currentThread();
        Integer accessCount = readingThreads.get(callingThread);
        if(null != accessCount){
            if(accessCount == 1){
                readingThreads.remove(callingThread);
            }else {
                readingThreads.put(callingThread,accessCount -1);
            }
        }
        notifyAll();
    }

    private boolean canGrantRead(Thread callingThread){
        //写锁线程得到读锁
        if(writeThread == callingThread){
            return true;
        }
        if(writeThread != null){
            return false;
        }
//        //有读锁存在
//        if(hasReaders()){
//            return false;
//        }
        //线程存在读操作
        if(isReader(callingThread)){
            return true;
        }
        if(writeRequests > 0){
            return false;
        }
        return true;
    }

    public boolean isReader(Thread callingThread){
        return readingThreads.get(callingThread) != null;
    }

    public synchronized void lockWrite() throws InterruptedException{
        writeRequests++;
        //当需要写锁时，判断是否有读操作或写操作
//        while (readers > 0 || writers > 0){
//            wait();
//        }
        Thread callingThread = Thread.currentThread();
        while (!canGrantWrite(callingThread)){
            wait();
        }
        //没有读写操作就将写请求递减
        writeRequests--;
        //将写锁次数递加
        writeAccesses++;
//        writers++;

        //把当前线程赋予写线程管程
        writeThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException{
        writeAccesses--;
        //写锁请求清除后，当前线程即可完成任务，交出锁
        if(writeAccesses == 0){
            writeThread = null;
        }
        notifyAll();
    }

    private boolean canGrantWrite(Thread callingThread){
        //判断线程是否拥有唯一读锁，读锁升级写锁
        if(isOnlyReader(callingThread)){
            return true;
        }
        //存在读操作
        if(hasReaders()){
            return false;
        }
        //没有写操作线程
        if(null == writeThread){
            return true;
        }
        if(writeThread != callingThread){
            return false;
        }
        return true;
    }

    private boolean hasReaders(){
        return readingThreads.size() > 0;
    }

    private boolean isOnlyReader(Thread callingThread){
        return readingThreads.size() == 1 &&
                readingThreads.get(callingThread) != null;
    }
}
