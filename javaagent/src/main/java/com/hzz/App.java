package com.hzz;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new MyThread("myThread"), 0, 3, TimeUnit.SECONDS);
        MyClass mc = new MyClass();
        mc.setName("aa");
        System.out.println(mc.getName());
    }
}
