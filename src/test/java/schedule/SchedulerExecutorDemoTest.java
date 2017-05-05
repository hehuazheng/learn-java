package schedule;

import org.junit.Test;

/**
* SchedulerExecutorDemo Tester. 
* 
* @author <Authors name> 
*/ 
public class SchedulerExecutorDemoTest {
    @Test
    public void testGetGroupName() {
        SecurityManager sm = System.getSecurityManager();
        System.out.println(sm.getThreadGroup());
    }
} 
