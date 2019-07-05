package com.hzz;

import com.sun.tools.attach.VirtualMachine;

import java.lang.management.ManagementFactory;

public class App {
    public static void main(String[] args) throws Exception {
//        attach();
        MyClass mc = new MyClass();
        mc.setName("aa");
        System.out.println(mc.getName());
    }

    public static String getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        name = name.substring(0, name.indexOf('@'));
        return name;
    }

    public static void attach() throws Exception {
        VirtualMachine vm = VirtualMachine.attach(getPid());
        try {
            vm.loadAgent("./javaagent/target/javaagent-1.0-SNAPSHOT-jar-with-dependencies.jar");
        } finally {
            vm.detach();
        }
    }
}
