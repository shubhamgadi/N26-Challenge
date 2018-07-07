package com.bank.report.entity;

public class TransationEntity implements Cloneable {
	private double amount;
	private long timestamp;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TransationEntity [amount=" + amount + ", timestamp=" + timestamp + "]";
	}

	public TransationEntity(double amount, long timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;

	}

	public TransationEntity() {
		super();
	}

}
