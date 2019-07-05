package study.java;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledJobDemo {

	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors
				.newScheduledThreadPool(ManagementFactory
						.getOperatingSystemMXBean().getAvailableProcessors());
		ses.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				System.out.println(sdf.format(date));
			}
		}, 3L, 3L, TimeUnit.SECONDS);

	}

}
