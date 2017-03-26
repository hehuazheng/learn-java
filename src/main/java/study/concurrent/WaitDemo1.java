package study.concurrent;

public class WaitDemo1 {
    public static void main(String[] args) {
        WaitDemo1 wd = new WaitDemo1();
        Thread1 t1 = wd.new Thread1();
        Thread1 t12 = wd.new Thread1();
        Thread2 t2 = wd.new Thread2();
        t1.start();
        t12.start();
        t2.start();
    }

    private Object lock = new Object();

    class Thread1 extends Thread {
        @Override
        public void run() {
            WaitDemo1.this.m1();
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("notify m1");
            WaitDemo1.this.m2();
        }
    }

    public void m1() {
        synchronized (lock) {
            try {
                System.out.println("m1");
                lock.wait();
                System.out.println("m2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (lock) {
            lock.notifyAll();//notifyAll必须在同步块中
        }
    }
}
