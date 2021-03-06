package org.pitest.mutationtest.engine.gregor.Mymutators;

import java.util.HashMap;   
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation; 

public enum AODIgnoreSecond implements MethodMutatorFactory {

   AOD_MUTATOR;

    @Override
    public MethodVisitor create(final MutationContext context,
        final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
      return new MathMethodVisitor(this, methodInfo, context, methodVisitor);
    }

    @Override
    public String getGloballyUniqueId() {
      return this.getClass().getName();
    }

    @Override
    public String getName() {
      return name();
    }

  }

  class MathMethodVisitor extends AbstractInsnMutator {

    MathMethodVisitor(final MethodMutatorFactory factory,
        final MethodInfo methodInfo, final MutationContext context,
        final MethodVisitor writer) {
      super(factory, methodInfo, context, writer);
    }

    private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

    static {
        //ignore the second one
      MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.POP,
          "(AOD int +)Ignore second character in stuck"));   //+
      MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.POP,
            "(AOD int -)Ignore second character in stuck")); //-
      MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.POP,
            "(AOD int *)Ignore second character in stuck")); //*
      MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.POP,
            "(AOD int /)Ignore second character in stuck")); // _/
      MUTATIONS.put(Opcodes.IOR, new InsnSubstitution(Opcodes.POP,
            "(AOD int |)Ignore second character in stuck")); // binary 'or'   
      MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.POP,
            "(AOD int &)Ignore second character in stuck")); // binary 'and' 
      MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.POP,
            "(AOD int %)Ignore second character in stuck")); // % 
      MUTATIONS.put(Opcodes.IXOR,  new InsnSubstitution(Opcodes.POP,
            "(AOD int xor)Ignore second character in stuck")); // xor
      MUTATIONS.put(Opcodes.ISHL,  new InsnSubstitution(Opcodes.POP,
            "(AOD int arth left shift)Ignore second character in stuck")); // arth left shift 
      MUTATIONS.put(Opcodes.ISHR,  new InsnSubstitution(Opcodes.POP,
            "(AOD int arth right shift)Ignore second character in stuck")); // arth right shift
      MUTATIONS.put(Opcodes.IUSHR,  new InsnSubstitution(Opcodes.POP,
            "(AOD int logical right shift)Ignore second character in stuck")); //  logical right shift

      // longs   

      MUTATIONS.put(Opcodes.LADD,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long +)Ignore second character in stuck"));  
      MUTATIONS.put(Opcodes.LSUB,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long -)Ignore second character in stuck")); 
      MUTATIONS.put(Opcodes.LMUL,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long *)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LDIV,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long /)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LOR,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long |)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LAND,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long &)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LREM,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long %)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LXOR,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long xor)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LSHL,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long arth left shift)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LSHR,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long arth right shift)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.LUSHR,  new InsnSubstitution(Opcodes.POP2,
            "(AOD long logical right shift)Ignore second character in stuck")); // 

      // floats
      MUTATIONS.put(Opcodes.FADD,  new InsnSubstitution(Opcodes.POP,
            "(AOD float +)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.FSUB,  new InsnSubstitution(Opcodes.POP,
            "(AOD float -)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.FMUL,  new InsnSubstitution(Opcodes.POP,
            "(AOD float *)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.FDIV,  new InsnSubstitution(Opcodes.POP,
            "(AOD float /)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.FREM,  new InsnSubstitution(Opcodes.POP,
            "(AOD float %)Ignore second character in stuck")); // 

      // doubles
      MUTATIONS.put(Opcodes.DADD,  new InsnSubstitution(Opcodes.POP2, 
            "(AOD double +)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.DSUB,  new InsnSubstitution(Opcodes.POP2,
            "(AOD double -)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.DMUL,  new InsnSubstitution(Opcodes.POP2,
            "(AOD double *)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.DREM,  new InsnSubstitution(Opcodes.POP2,
              "((AOD double %)Ignore second character in stuck")); // 
      MUTATIONS.put(Opcodes.DDIV,  new InsnSubstitution(Opcodes.POP2,
            "(AOD double /)Ignore second character in stuck")); // 
      

      
      //pop ignore first one
//      MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.POP2,
//              "(AOD int +)Ignore first character in stuck"));   //+
//          MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.POP2,
//                "(AOD int -)Ignore first character in stuck")); //-
    }

    
    @Override
    protected Map<Integer, ZeroOperandMutation> getMutations() {
      return MUTATIONS;
    }

  }

