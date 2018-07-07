package com.bank.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.report.entity.Statistics;
import com.bank.report.entity.TransationEntity;
import com.bank.report.service.StatisticsService;

@RestController
public class StatisticsController {

	@Autowired
	private StatisticsService statisticService;

	@RequestMapping(value = "/transactions", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> add(@RequestBody TransationEntity transationEntity) {
		boolean isPast = statisticService.addTransation(transationEntity);
		if (isPast)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
	public Statistics get​Statistics() {
		return statisticService.get​Statistics();
	}
}
