package com.codersongs.vmstudy.classloader;

/**
 * @author wusongsong
 * @date 2019/1/7
 */
public class PrintClassLoaderTree {
    public static void main(String[] args) {
        ClassLoader classLoader = PrintClassLoaderTree.class.getClassLoader();
        while (classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        System.out.println(String.class.getClassLoader());
    }
}
