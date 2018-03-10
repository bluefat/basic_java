package com.study.io;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class StudyPiping {

    public static void main(String[] args)throws Exception{
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pipedOutputStream.write("ceshi".getBytes());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buf = new byte[1024];
                    int len = pipedInputStream.read(buf);
                    String str = new String(buf,0,len);
                    System.out.println(str);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
