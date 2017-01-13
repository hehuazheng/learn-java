package study.thrift;

/**
 * Created by hejf on 2017/1/13.
 */
public class ThriftTestServiceHandler implements  org.apache.thrift.async.AsyncMethodCallback<java.lang.String> {
    @Override
    public void onComplete(String s) {
        System.out.println("handler :" +s);
    }

    @Override
    public void onError(Exception e) {
        System.out.println("handler :" + e.getMessage());
    }
}
