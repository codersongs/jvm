package com.codersongs.vmstudy.agent;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class TimeStatMethodAdapter extends MethodAdapter{

    public TimeStatMethodAdapter(MethodVisitor ss){
        super(ss);
    }

    @Override
    public void visitCode(){
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "asmtimer/TimeStat",
                "start", "()V");
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode){
        if(opcode>=Opcodes.IRETURN&&opcode<=Opcodes.RETURN){
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "asmtimer/TimeStat",
                    "end", "()V");
        }
        mv.visitInsn(opcode);
    }
}