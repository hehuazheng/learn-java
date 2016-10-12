package com.hzz.learn.java.serviceloader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderMain {
	public static void main(String[] args) {
		ServiceLoader<GreetingService> sl = ServiceLoader.load(GreetingService.class);
		Iterator<GreetingService> itor = sl.iterator();
		while(itor.hasNext()) {
			GreetingService gs = itor.next();
			gs.sayHello("aa");
		}
		System.out.println("end");
	}
}
