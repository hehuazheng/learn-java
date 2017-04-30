package proxy;

import anno.MyProfile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyDemo1 {
    static class InnerServiceImpl implements InnerService {
        @MyProfile
        public String m1(String s) {
            System.out.println("m1 " + s);
            return s + "@m1";
        }

        @MyProfile
        public void m2() {
            System.out.println("m2");
        }
    }

    static class ProfileInvocationHandler<T> implements InvocationHandler {
        private T t;

        public ProfileInvocationHandler(T t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object res = method.invoke(t, args);
            System.out.println("time " + (System.currentTimeMillis() - start));
            return res;
        }
    }

    static <T> T getWrapper(Class<T> clazz, T obj) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ProfileInvocationHandler<T>(obj));
    }

    public static void main(String[] args) throws NoSuchMethodException {
        InnerService is = getWrapper(InnerService.class, new InnerServiceImpl());
        is.m1("aa");
    }
}
