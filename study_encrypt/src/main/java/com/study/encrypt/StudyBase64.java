package com.study.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class StudyBase64 {

    public static void main(String[] args)throws Exception{
        String s = "ceshi";
        System.out.println("加密前" + s);
        String ss = new BASE64Encoder().encodeBuffer(s.getBytes());
        System.out.println("加密后" + ss);
        String sss = new String(new BASE64Decoder().decodeBuffer(ss));
        System.out.println("解密后" + sss);
    }


}
