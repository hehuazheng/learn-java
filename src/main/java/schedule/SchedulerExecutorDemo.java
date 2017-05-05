package schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1, new NamedThreadFactory("hzz"));
        scheduler.scheduleWithFixedDelay(() -> {
                    System.out.println(new Date());
                }
                , 0, 3, TimeUnit.SECONDS);
        Thread.sleep(10000);
    }

    static class NamedThreadFactory implements ThreadFactory {
        private String name;
        private final ThreadGroup threadGroup;

        NamedThreadFactory(String name) {
            SecurityManager manager = System.getSecurityManager();
            threadGroup = manager == null ? Thread.currentThread().getThreadGroup() : manager.getThreadGroup();
            this.name = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(threadGroup, r, name);
            t.setDaemon(true);
            return t;
        }
    }
}
