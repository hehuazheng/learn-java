package java8;

public interface Interface1 {
    default String name() {
        return "test name";
    }

    String addr();
}
