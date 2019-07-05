package study.concurrent;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock mlock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock rlock = mlock.readLock();
        ReentrantReadWriteLock.WriteLock wLock = mlock.writeLock();
        new MyWriteThread(wLock).start();
        new MyThread(rlock).start();
        new MyWriteThread(wLock).start();
        new MyThread(rlock).start();
    }

    static class MyThread extends Thread {
        ReentrantReadWriteLock.ReadLock readLock;

        public MyThread(ReentrantReadWriteLock.ReadLock readLock) {
            this.readLock = readLock;
        }

        @Override
        public void run() {
            try {
                System.out.println("read lock: " + Thread.currentThread().getName() + new Date());
                readLock.lock();
                Thread.sleep(3000L);
                System.out.println("read lock: " + Thread.currentThread().getName() + " end " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }
    }

    static class MyWriteThread extends Thread {
        ReentrantReadWriteLock.WriteLock writeLock;

        public MyWriteThread(ReentrantReadWriteLock.WriteLock writeLock) {
            this.writeLock = writeLock;
        }

        @Override
        public void run() {
            try {
                System.out.println("write lock: " + Thread.currentThread().getName() + new Date());
                writeLock.lock();
                Thread.sleep(3000L);
                System.out.println("write lock: " + Thread.currentThread().getName() + " end " + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }
    }
}
