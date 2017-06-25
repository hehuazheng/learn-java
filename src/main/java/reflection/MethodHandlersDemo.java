package reflection;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlersDemo {
    public static void main(String[] args) throws Throwable {
        String res = (String) MethodHandles.lookup().findStatic(A.class, "convert", MethodType.methodType(String.class, String.class)).invoke("hejf");
        System.out.println(res);
        res = (String) MethodHandles.lookup().findStatic(A.class, "convert", MethodType.methodType(String.class, String.class)).invokeWithArguments("hejf");
        System.out.println(res);
    }

    static class A {
        public static String convert(String s) {
            System.out.println("s:" + s);
            return "convert:" + s;
        }

        private static String convert1(String s) {
            System.out.println("s:" + s);
            return "convert:" + s;
        }
    }
}
