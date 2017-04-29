package java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParameterCaptureDemo {
    public int process(@FieldAnno1("np") String name, String addr, int age) {
        System.out.println(name + " " + addr + " " + age);
        return Math.abs(age) + 1;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method m = ParameterCaptureDemo.class.getDeclaredMethod("process", String.class, String.class, int.class);
        //需要设置编译保留 -parameters
        for (Parameter p : m.getParameters()) {
            System.out.println(p.getName() + " " + p.getType() + " ");
            FieldAnno1 fa = p.getAnnotation(FieldAnno1.class);
            if (fa != null) {
                System.out.println(fa.value());
            }
//             name class java.lang.String
//             addr class java.lang.String
//             age int
        }
    }
}
