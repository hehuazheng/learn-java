package study.java;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		int n = 3;
		CountDownLatch cdl = new CountDownLatch(n);
		for (int i = 0; i < n; i++) {
			new MyThread(cdl).start();
		}
		System.out.println("before cound down latch");
		cdl.await();
		System.out.println("task completed");
	}

	static class MyThread extends Thread {
		private CountDownLatch cdl;

		public MyThread(CountDownLatch cdl) {
			this.cdl = cdl;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()
					+ " sleep 2 seconds");
			cdl.countDown();
		}
	}

}
