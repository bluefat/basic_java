package com.study.list;

import java.util.ArrayList;

import static java.lang.System.out;

public class StudyArrayList {

    public static void main(String[] args){


    }

    /**
     * 实现Cloneable(实际调用Objectde native方法)
     * protected native Object clone() throws CloneNotSupportedException;
     */
    public void testClone(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("ceshi");
        ArrayList arrayList2 = (ArrayList)arrayList.clone();
        out.println(arrayList2.get(0));
    }
}
