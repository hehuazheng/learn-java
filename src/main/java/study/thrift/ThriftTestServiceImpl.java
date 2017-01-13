package study.thrift;

import org.apache.thrift.TException;

/**
 * Created by hejf on 2017/1/13.
 */
public class ThriftTestServiceImpl implements  ThriftTestService.Iface {
    @Override
    public String sayhello(String name) throws TException {
        return "hello : " + name;
    }
}
