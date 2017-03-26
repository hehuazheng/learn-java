package study.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        ReentrantLockDemo1 rd = new ReentrantLockDemo1();
        rd.m1(3);
    }

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    public void m1(long timeout) {
        try {
            lock.lockInterruptibly();
            System.out.println("m1 condition wait " + timeout);
            condition.await(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void m2(long timeout) {
        try {
            lock.lockInterruptibly();
            System.out.println("m2 condition wait " + timeout);
            condition.await(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
