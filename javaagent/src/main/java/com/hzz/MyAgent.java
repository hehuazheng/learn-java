package com.hzz;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author: hezz
 */
public class MyAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                if (className.equals("com/hzz/MyClass")) {
                    System.out.println("start transform MyClass");
                    try {
                        ClassPool cp = ClassPool.getDefault();
                        CtClass cc = cp.get("com.hzz.MyClass");
                        CtMethod m = cc.getDeclaredMethod("getName");
                        m.addLocalVariable("elapsedTime", CtClass.longType);
                        m.insertBefore("elapsedTime = System.currentTimeMillis();");
                        m.insertAfter("{elapsedTime = System.currentTimeMillis() - elapsedTime;"
                                + "System.out.println(\"Method Executed in ms: \" + elapsedTime);}");
//                        m.insertBefore("System.out.println(\"start method getName\");");
//                        m.insertAfter("System.out.println(\"end method getName\");");
                        byte[] byteCodes = cc.toBytecode();
                        cc.detach();
                        return byteCodes;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        });
    }

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        premain(agentArgs, instrumentation);
    }

}
