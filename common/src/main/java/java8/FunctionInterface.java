package java8;

public interface FunctionInterface {
    void process();

    public static void main(String[] args) {
        FunctionInterface fi = () -> {
            System.out.println("yes");
            System.out.println("b");
        };
        fi.process();
    }
}
