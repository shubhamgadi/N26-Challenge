package com.bank.report.service;

import com.bank.report.entity.Statistics;
import com.bank.report.entity.TransationEntity;

public interface StatisticsService {
	public boolean addTransation(TransationEntity transationEntity);

	public Statistics get​Statistics();
}
