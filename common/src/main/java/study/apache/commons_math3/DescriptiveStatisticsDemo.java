package study.apache.commons_math3;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStatisticsDemo {

	public static void main(String[] args) {
		DescriptiveStatistics stat = new DescriptiveStatistics();
		stat.addValue(1.0);
		stat.addValue(10);
		System.out.println("max: " + stat.getMax() + ", min:" + stat.getMin()
				+ ",sum:" + stat.getSum());
	}

}
