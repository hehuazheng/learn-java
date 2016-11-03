package com.study.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppenderDemo {
	//slf4j不生效
	private static final Logger LOG = LoggerFactory.getLogger("myapp");
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("myapp");
	
	public static void main(String[] args) {
		log.info("say sth");
		System.out.println("============");
		LOG.info("aaabb");
	}

}
