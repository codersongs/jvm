package com.codersongs.vmstudy.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author wusongsong
 * @date 2019/1/7
 */
public class FindClassOrder3 {
    public static void main(String args[]) throws Exception {
        ClassLoader cl=FindClassOrder3.class.getClassLoader();
        byte[] bHelloLoader=loadClassBytes("HelloLoader");
        Method md_defineClass=ClassLoader.class.getDeclaredMethod("defineClass", byte[].class,int.class,int.class);
        md_defineClass.setAccessible(true);
        md_defineClass.invoke(cl, bHelloLoader,0,bHelloLoader.length);
        md_defineClass.setAccessible(false);

        Object loader =  cl.getParent().loadClass("HelloLoader").newInstance();
        System.out.println(loader.getClass().getClassLoader());
        Method m=loader.getClass().getMethod("print", null);
        m.invoke(loader, null);
    }

    private static String getClassFile(String name) {
        StringBuffer sb = new StringBuffer(".");
        name = name.replace('.', File.separatorChar) + ".class";
        sb.append(name);
        return sb.toString();
    }

    private static byte[] loadClassBytes(String className) throws ClassNotFoundException {
        try {
            String classFile = getClassFile(className);
            FileInputStream fis = new FileInputStream(classFile);
            FileChannel fileC = fis.getChannel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableByteChannel outC = Channels.newChannel(baos);
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (true) {
                int i = fileC.read(buffer);
                if (i == 0 || i == -1) {
                    break;
                }
                buffer.flip();
                outC.write(buffer);
                buffer.clear();
            }
            fis.close();
            return baos.toByteArray();
        } catch (IOException fnfe) {
            throw new ClassNotFoundException(className);
        }
    }
}
