package reflection;

public class ReflectionDemo1 {
    void m1() {
        System.out.println("m1 without parameters");
    }

    void m2(String s) {
        System.out.println("m2 with " + (s == null ? "null" : s));
    }

    public static void main(String[] args) {
        ReflectionDemo1 rt = new ReflectionDemo1();
//        ReflectionDemo1.class.getDeclaredMethod()
    }
}
