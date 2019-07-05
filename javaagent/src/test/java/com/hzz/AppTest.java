package com.hzz;

import org.junit.Test;

/**
 * @author: hezz
 */
public class AppTest {
    @Test
    public void t1() {
        System.out.println(MyClass.class.getCanonicalName().replace('.', '/'));
    }
}
