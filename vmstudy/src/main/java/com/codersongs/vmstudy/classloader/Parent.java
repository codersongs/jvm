package com.codersongs.vmstudy.classloader;

/**
 * @author wusongsong
 * @date 2019/1/7
 */
public class Parent {
    static {
        System.out.println("Parent init");
    }
    public static int v = 100;
}
