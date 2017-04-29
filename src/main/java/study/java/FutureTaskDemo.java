package study.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		FutureTask<String> fTask = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						System.out.println("in call start");
						Thread.sleep(3000L);
						System.out.println("in call end");
						return "called";
					}
				});
		fTask.run();
		System.out.println("after future task run");
		String result = fTask.get();
		System.out.println(result);
	}

}
