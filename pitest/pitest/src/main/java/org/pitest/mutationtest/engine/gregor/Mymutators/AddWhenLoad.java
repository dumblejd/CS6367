package org.pitest.mutationtest.engine.gregor.Mymutators;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public class AddWhenLoad implements MethodMutatorFactory {

    @Override
    public MethodVisitor create(MutationContext context, MethodInfo methodInfo, MethodVisitor methodVisitor) {
        return new AddWhenLoadVisitor(this, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
        // TODO Auto-generated method stub
        return this.getClass().getName();
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return toString();
    }

}
class AddWhenLoadVisitor extends MethodVisitor {
    
    private final MethodMutatorFactory factory;
    private final MutationContext      context;
    
    AddWhenLoadVisitor (final MethodMutatorFactory factory,
            final MutationContext context,
            final MethodVisitor delegateMethodVisitor) {
          super(Opcodes.ASM6, delegateMethodVisitor);
          this.context = context;
          this.factory = factory;
        }
    @Override
    public void visitVarInsn(final int opcode, final int var) {
        if (opcode == Opcodes.ILOAD) {
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.DUP);
            this.mv.visitInsn(Opcodes.ICONST_1);
            this.mv.visitInsn(Opcodes.IADD);
            this.mv.visitVarInsn(Opcodes.ISTORE,var);
        } else if (opcode == Opcodes.DLOAD) {
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.DUP2);
            this.mv.visitInsn(Opcodes.DCONST_1);
            this.mv.visitInsn(Opcodes.DADD);
            this.mv.visitVarInsn(Opcodes.DSTORE,var);
        } else if (opcode == Opcodes.FLOAD) {
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.DUP);
            this.mv.visitInsn(Opcodes.FCONST_1);
            this.mv.visitInsn(Opcodes.FADD);
            this.mv.visitVarInsn(Opcodes.FSTORE,var);
        } else if (opcode == Opcodes.LLOAD) {
            super.visitVarInsn(opcode,var);
            this.mv.visitInsn(Opcodes.DUP2);
            this.mv.visitInsn(Opcodes.LCONST_1);
            this.mv.visitInsn(Opcodes.LADD);
            this.mv.visitVarInsn(Opcodes.LSTORE, var);
        } else {
            super.visitVarInsn(opcode, var);
        }
    }
    }

