package study.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftTestServer {
//    public static ThriftTestServiceHandler handler;
    public static ThriftTestService.Processor<ThriftTestServiceImpl> processor;

    public static void main(String[] args) throws TTransportException {
//        handler = new ThriftTestServiceHandler();
        ThriftTestServiceImpl impl = new ThriftTestServiceImpl();
        processor = new ThriftTestService.Processor<ThriftTestServiceImpl>(impl);

        TServerTransport serverTransport = new TServerSocket(9090);
        TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
        System.out.println("starting the simple server");
        server.serve();
    }
}
