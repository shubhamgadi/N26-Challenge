package com.bank.report.entity;

public class Statistics {

	private double sum;
	private double count;
	private double average;
	private double max;
	private double min;

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	@Override
	public String toString() {
		return "Report [sum=" + sum + ", count=" + count + ", average=" + average + ", max=" + max + ", min=" + min
				+ "]";
	}

}
