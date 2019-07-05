package study.jmx;

public class MyWords implements MyWordsMBean {
    @Override
    public String saySth(String words) {
        System.out.println(words);
        return "yes it's " + words;
    }
}
