package java8.stream;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        String[] arr = "a,b,c".split(",");
        Arrays.stream(arr).filter(s -> !s.equals("b")).forEach(System.out::println);
        List<String> list = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(list);

        String[] barr = "a:1,b:2,c:3".split(",");
        List<HostAndPort> list2 = Arrays.stream(barr).map(StreamDemo::parse).collect(Collectors.toList());
        System.out.println(list2);
    }

    static HostAndPort parse(String s){
        String[] arr = s.split(":");
        HostAndPort hp = new HostAndPort();
        hp.setHost(arr[0]);
        hp.setPort(Integer.parseInt(arr[1]));
        return hp;
    }

    static class HostAndPort {
        private String host;
        private int port;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }
}
