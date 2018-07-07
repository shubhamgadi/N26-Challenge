package com.bank.report.service_test;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTimeUtils;
import org.junit.Test;

import com.bank.report.entity.Statistics;
import com.bank.report.entity.TransationEntity;
import com.bank.report.service.StatisticsService;
import com.bank.report.service.impl.StatisticsServiceImpl;

public class StatisticsServiceImplTest {

	private StatisticsService reportService = new StatisticsServiceImpl();

	@Test
	public void validateResultWithinTimeFrame() throws Exception {
		DateTimeUtils.setCurrentMillisFixed(1530893434260l);
		long currentTime = 1530893434260l;
		TransationEntity transationEntity = new TransationEntity(1, currentTime);
		reportService.addTransation(transationEntity);
		transationEntity = new TransationEntity(2, currentTime);
		reportService.addTransation(transationEntity);
		transationEntity = new TransationEntity(3, currentTime);
		reportService.addTransation(transationEntity);

		Statistics statis = reportService.get​Statistics();
		assertEquals(new Double(1), new Double(statis.getMin()));
		assertEquals(new Double(3), new Double(statis.getMax()));
		assertEquals(new Double(6), new Double(statis.getSum()));
		assertEquals(new Double(2), new Double(statis.getAverage()));
		assertEquals(new Double(3), new Double(statis.getCount()));

	}

	@Test
	public void validateResultAfterTimeFrame() throws Exception {

		DateTimeUtils.setCurrentMillisFixed(1530893434260l);
		long currentTime = 1530893434260l;
		TransationEntity transationEntity = new TransationEntity(1, currentTime);
		reportService.addTransation(transationEntity);
		transationEntity = new TransationEntity(2, currentTime);
		reportService.addTransation(transationEntity);
		transationEntity = new TransationEntity(3, currentTime);
		reportService.addTransation(transationEntity);

		DateTimeUtils.setCurrentMillisFixed(1530893770666l);
		Statistics statis = reportService.get​Statistics();
		assertEquals(new Double(0), new Double(statis.getMin()));
		assertEquals(new Double(0), new Double(statis.getMax()));
		assertEquals(new Double(0), new Double(statis.getSum()));
		assertEquals(new Double(0), new Double(statis.getAverage()));
		assertEquals(new Double(0), new Double(statis.getCount()));

	}

}
