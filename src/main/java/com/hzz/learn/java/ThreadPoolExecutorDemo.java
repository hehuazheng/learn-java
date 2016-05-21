package com.hzz.learn.java;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorDemo {

	public static void main(String[] args) {
		int n = 20;
		for (int i = 0; i < n; i++) {
			MyThreadPoolExecutor.execute(new MyThread(i + ""));
		}
		MyThreadPoolExecutor.shutdonw();
	}

	static class MyThreadPoolExecutor {
		private static ExecutorService es = Executors.newFixedThreadPool(2);

		public static void execute(Runnable command) {
			es.execute(command);
		}

		public static void shutdonw() {
			es.shutdown();
		}
	}

	static class MyThread extends Thread {
		private String name;

		public MyThread(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name + " start " + new Date());
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " end " + new Date());
		}

	}

}
