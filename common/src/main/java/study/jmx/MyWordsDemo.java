package study.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MyWordsDemo {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        MyWords myWords = new MyWords();
        ObjectName objectName = new ObjectName("agent:name=mywords");
        server.registerMBean(myWords, objectName);
        Thread.sleep(300000L);
    }
}
