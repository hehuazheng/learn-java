package com.hzz.learn.java.serviceloader;

public class ConsoleGreetingServiceImpl implements GreetingService {

	@Override
	public void sayHello(String txt) {
		System.out.println("console:" + txt);
	}
}
