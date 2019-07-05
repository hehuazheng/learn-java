package proxy;

import anno.MyProfile;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyDemo1 {

    static class InnerServiceImpl {
        @MyProfile
        public String m1(String s) {
            System.out.println("m1 " + s);
            return s + "@m1";
        }

        @MyProfile
        public void m2() {
            System.out.println("m2");
        }

        public void m3() {
            System.out.println("m3");
        }
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InnerServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                MyProfile profile = method.getAnnotation(MyProfile.class);
                if (profile != null) {
                    long start = System.currentTimeMillis();
                    Object res = proxy.invokeSuper(obj, args);
                    System.out.println("time consumed: " + (System.currentTimeMillis() - start));
                    return res;
                } else {
                    return proxy.invokeSuper(obj, args);
                }
            }
        });
        InnerServiceImpl isi = (InnerServiceImpl) enhancer.create();
        isi.m1("hzz");
        isi.m2();
        isi.m3();
    }
}
