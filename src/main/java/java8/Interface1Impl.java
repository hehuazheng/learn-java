package java8;

public class Interface1Impl implements Interface1 {
    @Override
    public String addr() {
        return "myaddr";
    }

    public static void main(String[] args) {
        Interface1Impl ii = new Interface1Impl();
        System.out.println(ii.name());
        System.out.println(ii.addr());
    }
}
