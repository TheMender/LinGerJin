package visitor;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.FieldVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.IOException;

import static jdk.internal.org.objectweb.asm.Opcodes.ASM4;

public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM4);
    }

    public ClassPrinter(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public void visit(final int version,
                      final int access,
                      final String name,
                      final String signature,
                      final String superName,
                      final String[] interfaces) {
        System.out.println(name + " extends " + superName);
    }

    @Override
    public FieldVisitor visitField(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final Object value) {

        System.out.println("  " + name);
        return null;
    }

    public MethodVisitor visitMethod(
            final int access,
            final String name,
            final String descriptor,
            final String signature,
            final String[] exceptions) {
        System.out.println("" + name);
        return null;
    }

    public void visitEnd() {
        System.out.println(" }");
    }

    public static void main(String[] args) {
        ClassPrinter classPrinter = new ClassPrinter();
        ClassReader reader = null;
        try {
            reader = new ClassReader("java.lang.Runnable");
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.accept(classPrinter,0);
    }
}
