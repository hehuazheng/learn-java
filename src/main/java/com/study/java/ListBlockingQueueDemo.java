package com.study.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;

public class ListBlockingQueueDemo {
	static int cnt = 10;

	public static void main(String[] args) throws InterruptedException {
		final LinkedBlockingDeque<String> lbd = new LinkedBlockingDeque<String>(
				5);
		for (int i = 0; i < 10; i++) {
			boolean res = lbd.offer("" + i);
			System.out.println(res);
		}

		new Thread() {
			public void run() {
				int max = 200;
				for(int i = 0; i < max; i++) {
					try {
						Thread.sleep(200L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					lbd.offer(" " + cnt);
					cnt++;
				}
			}
		}.start();

		for (int i = 0; i < 100; i++) {
			ThreadExecutor.execute(new MyThread(lbd.take()));
		}
	}
}

class MyThread extends Thread {
	private String msg;

	public MyThread(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("enter " + msg);
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("leave " + msg);
	}
}

class ThreadExecutor {
	private static final int POOL_SIZE = 2;
	private static ExecutorService executorService;

	private static ExecutorService getExecutor() {
		if (executorService == null || executorService.isShutdown()) {
			synchronized (ThreadFactory.class) {
				if (executorService == null || executorService.isShutdown()) {
					executorService = Executors.newFixedThreadPool(POOL_SIZE);
				}
			}
		}
		return executorService;
	}

	public static <T extends Runnable> void execute(T thread) {
		getExecutor().execute(thread);
	}

	public static <T> Future<T> submit(Callable<T> task) {
		return getExecutor().submit(task);
	}

}
