package com.study.io;

import java.io.DataInputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


public class StudyDataInputStream {

    public static void main(String[] args) throws Exception{
//        RandomAccessFile
//        DataInputStream
//        CopyOnWriteArrayList
//        Connec

//        ThreadLocal
//        SequenceInputStream

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\XY\\Desktop\\面试.txt","rw")){
            randomAccessFile.seek(100);
            System.out.println(randomAccessFile.getFilePointer());
        }
    }
}
