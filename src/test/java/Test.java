import java.nio.ByteBuffer;

public class Test {
    @org.junit.Test
    public void testT1() {
        long i = 0x212345567L;
        System.out.printf("%x, %x", m1(i), m2(i));
    }

    @org.junit.Test
    public void testT2() {
        int wchpCmd = ByteBuffer.wrap("wchp".getBytes()).getInt();
        int wchsCmd = ByteBuffer.wrap("wchs".getBytes()).getInt();
        System.out.printf("%x, %x", wchpCmd, wchsCmd);
        System.out.println();
        int v = ByteBuffer.wrap("aaaa".getBytes()).getInt();
        System.out.printf("%x", v );
    }

    static long m1(long val) {
        return val & ~0xffffffffL;
    }

    static long m2(long val) {
        return (val >> 32) << 32;
    }
}
