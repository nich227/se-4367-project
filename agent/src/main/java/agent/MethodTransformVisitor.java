package agent; 

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class MethodTransformVisitor extends MethodVisitor implements Opcodes {

    String mName;
    int line;

    public MethodTransformVisitor(final MethodVisitor mv, String name) {
        super(ASM4, mv);
        this.mName = name;
    }

    // method coverage collection
    @Override
    public void visitCode() {
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn(mName + " executed");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        super.visitCode();
    }

    // statement coverage collection
    @Override
    public void visitLineNumber(int line, Label start) {
        this.line = line;

    	mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("line " + line + " executed");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        super.visitLineNumber(line, start);
    }

    // visit a label
    @Override
    public void visitLabel(Label label) {
    	mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("line " + line + " executed");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        super.visitLabel(label);
    }
}