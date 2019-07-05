package java8;

public interface FunctionInterface2 {
    void process(String s);

    public static void main(String[] args) {
        FunctionInterface2 fi2 = (s) -> {
            System.out.println(s);
        };
        fi2.process("hzz");
    }
}
