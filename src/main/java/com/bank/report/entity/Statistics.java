package com.bank.report.entity;

public class Statistics {

	private double sum;
	private double count;
	private double avg;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Statistics [sum=" + sum + ", count=" + count + ", avg=" + avg + ", max=" + max + ", min=" + min + "]";
	}

}
