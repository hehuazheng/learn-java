package com.hzz.learn.java.serviceloader;

public class FileGreetingServiceImpl implements GreetingService {

	@Override
	public void sayHello(String txt) {
		System.out.println("file:" + txt);
	}

}
