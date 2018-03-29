package com.study.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class StudySelector {

    public static void main(String[] args){

        testSelector();


    }

    public static void testSelector(){
        try {

            Selector selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            //处于非阻塞模式下
            socketChannel.configureBlocking(false);
            socketChannel.bind(new InetSocketAddress(9010));
            //注册
            socketChannel.register(selector, SelectionKey.OP_CONNECT);


            Set selectorKey = selector.keys();
            Iterator iterator = selectorKey.iterator();
            while (true){
//                int conn = selector.select();
//                System.out.println(conn);
////                if(conn == 0) continue;
                if(iterator.hasNext()){

                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    if(selectionKey.isConnectable()){
                        System.out.println("连接就绪");
                    }else if(selectionKey.isAcceptable()){
                        System.out.println("接收就绪");
                    }else if(selectionKey.isReadable()){
                        System.out.println("读就绪");
                    }else if(selectionKey.isWritable()){
                        System.out.println("写就绪");
                    }
                }else {
                    System.out.println("暂无链接");
                    Thread.sleep(4000);
                }
//                iterator.remove();
            }

//            int interestSet = SelectionKey.OP_ACCEPT | SelectionKey.OP_READ | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE;
//            System.out.println(interestSet);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
