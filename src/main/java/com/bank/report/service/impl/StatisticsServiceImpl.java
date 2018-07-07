package com.bank.report.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.DateTimeUtils;
import org.springframework.stereotype.Service;

import com.bank.report.entity.Statistics;
import com.bank.report.entity.TransationEntity;
import com.bank.report.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	private static final long ONE_MINUTE = 60000;
	private Comparator<TransationEntity> amountComparator = new Comparator<TransationEntity>() {
		@Override
		public int compare(TransationEntity o1, TransationEntity o2) {
			return (int) (o1.getAmount() - o2.getAmount());
		}
	};
	private ArrayList<TransationEntity> entities = new ArrayList<>();

	@Override
	public boolean addTransation(TransationEntity transationEntity) {
		long currentTime = DateTimeUtils.currentTimeMillis();
		if (transationEntity.getTimestamp() < currentTime - ONE_MINUTE || transationEntity.getAmount() < 0)
			return true;
		else {
			synchronized (entities) {
				entities.add(transationEntity);
				entities = (ArrayList<TransationEntity>) getFilteredStream(entities, currentTime)
						.collect(Collectors.toList());
			}
		}
		return false;
	}

	@Override
	public Statistics get​Statistics() {
		Statistics report = new Statistics();
		long currentTime = DateTimeUtils.currentTimeMillis();
		List<TransationEntity> entities = Collections.EMPTY_LIST;
		synchronized (this.entities) {
			entities = (ArrayList<TransationEntity>) this.entities.clone();
		}
		entities = getFilteredStream(entities, currentTime).collect(Collectors.toList());
		Optional<TransationEntity> optionalMax = entities.stream().max(amountComparator);
		if (optionalMax.isPresent())
			report.setMax(optionalMax.get().getAmount());

		Optional<TransationEntity> optionalMin = entities.stream().min(amountComparator);
		if (optionalMin.isPresent())
			report.setMin(optionalMin.get().getAmount());

		double count = entities.size();
		double sum = entities.stream().map(trans -> trans.getAmount()).mapToDouble(Double::doubleValue).sum();

		report.setCount(count);
		report.setSum(sum);
		double average = count == 0 ? count : sum / count;
		report.setAverage(average);
		return report;
	}

	private Stream<TransationEntity> getFilteredStream(List<TransationEntity> transations, long currentTime) {
		return transations.stream().filter(tran -> tran.getTimestamp() > (currentTime - ONE_MINUTE));
	}

}
