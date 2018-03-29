package com.study.encrypt;

import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

public class StudyMD5 {

    public static void main(String[] args)throws Exception{
        String str = "44444";
        System.out.println("加密前的数据:" + str);
        //SHA-256,MD5,SHA-1等
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes();
        messageDigest.update(bytes);
        String ss = new BASE64Encoder().encodeBuffer(messageDigest.digest());
        System.out.println("MD5加密后:" + ss);
    }
}
