package study.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MyAppender extends AppenderSkeleton {
	private String customName;
	
	@Override
	public void close() {
	}

	@Override
	public boolean requiresLayout() {
		return true;
	}

	@Override
	protected void append(LoggingEvent event) {
		System.out.println("i'm " + customName);
		System.out.println(event.getLevel() + "#" + event.getMessage());
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}
}
