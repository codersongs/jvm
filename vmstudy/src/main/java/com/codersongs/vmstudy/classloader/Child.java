package com.codersongs.vmstudy.classloader;

/**
 * @author wusongsong
 * @date 2019/1/7
 */
public class Child extends Parent{
    static {
        System.out.println("Child init");
    }
}
