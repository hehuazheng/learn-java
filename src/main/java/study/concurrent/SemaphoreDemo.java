package study.concurrent;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Semaphore控制准入次数
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        MyThread[] arr = new MyThread[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MyThread(semaphore);
            arr[i].start();
        }
    }

    public static class MyThread extends Thread {
        private Semaphore semaphore;

        public MyThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(getName() + " run at " + new Date());
                Thread.sleep(3000L);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
