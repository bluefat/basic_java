package com.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class StudySelectorClient {

    public static void main(String[] args){
        try {
            SocketChannel socketChannel = SocketChannel.open();
            //处于非阻塞模式下
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress(9010));
            System.out.println(socketChannel.isConnected());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
