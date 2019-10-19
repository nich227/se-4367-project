package agent;

public class ClassTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader cl,  String s, Class<?> aClass, ProtectionDomain pd, byte[] bytes) throws IllegalClassFormatException {

        //Intercept the call to the class Stuff
        if("other/Stuff".equals(s)) {
            //ASM Code
            ClassReader read = new ClassReader(bytes);
            ClassWriter write = new ClassWriter(read, 0);
            ClassPrinter visit = newClassPrinter(write);
            read.accept(visitor, 0);
            return write.toByteArray();
        }
        else
            return null;
    }
}