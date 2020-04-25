package com.cdc.covid19.forecast.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdc.covid19.forecast.model.CdcData;
import com.cdc.covid19.forecast.model.ForecastData;
import com.cdc.covid19.forecast.services.ForecastService;

@RestController
@RequestMapping("forecast/api")
public class ForecastController {

	@Autowired
	ForecastService forecastService;
	
	@GetMapping(value = "/rawdata")
	public List<CdcData> getCDCRawData() {

		return forecastService.getCDCRawData();
	}
	
	@GetMapping(value = "/forecast-data")
	public List<ForecastData> getForecastData() {

		return forecastService.getForecastData();
	}

}
