package study.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftTestClient {
    public static void main(String[] args) throws Exception {
        TTransport transport = new TSocket("localhost", 9090);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        ThriftTestService.Client client = new ThriftTestService.Client(protocol);
        perform(client);
        transport.close();
    }

    private static void perform(ThriftTestService.Client client) throws TException {
        String r = client.sayhello("hzz");
        System.out.println("line 1" + r);
    }
}
