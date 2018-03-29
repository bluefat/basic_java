package com.study.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class StudyFileChannel {

    public static void main(String[] args){
        testTranfrom();

    }

    public static void testBuffer(){
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\XY\\Desktop\\sql.txt"),"rw");){
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            int byteread = fileChannel.read(byteBuffer);

//            while (byteread != -1){
//                System.out.println("read:" + byteread);
//                byteBuffer.flip();
//            }
//
//            while (byteBuffer.hasRemaining()){
//                System.out.println(byteBuffer.get());
//            }
//
//            byteBuffer.clear();
//            byteread = fileChannel.read(byteBuffer);
        }catch (Exception e){

        }
    }

    //通道转存数据
    public static void testTranfrom(){
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\XY\\Desktop\\测试文件\\fileChannel0.txt"),"rw");
             RandomAccessFile randomAccessFile1 = new RandomAccessFile(new File("C:\\Users\\XY\\Desktop\\测试文件\\fileChannel1.txt"),"rw");){

            FileChannel fileChannel = randomAccessFile.getChannel();
            FileChannel fileChannel1 = randomAccessFile1.getChannel();

            long position = 0;
            long count = fileChannel1.size();

            //将数据从fileChannel1传输到fileChannel
//            fileChannel1.transferTo(position,count,fileChannel);

            //将fileChannel1传输到fileChannel
            fileChannel.transferFrom(fileChannel1,position,count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
