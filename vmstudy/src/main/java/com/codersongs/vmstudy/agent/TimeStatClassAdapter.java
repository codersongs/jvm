package com.codersongs.vmstudy.agent;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
public class TimeStatClassAdapter extends ClassAdapter {

    public TimeStatClassAdapter(ClassVisitor cv){
        super(cv);
    }

    public MethodVisitor visitMethod(final int access,final String name,
                                     final String desc,final String signature,
                                     final String[] exceptions){
        MethodVisitor mv=cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv=mv;
        if(mv!=null){
            if(name.equals("operation")){
                wrappedMv=new TimeStatMethodAdapter(mv);
            }
        }
        return wrappedMv;
    }
}
