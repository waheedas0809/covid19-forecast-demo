package com.cdc.covid19.forecast.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdc.covid19.forecast.model.CdcData;
import com.cdc.covid19.forecast.model.ForecastData;
import com.cdc.covid19.forecast.types.TestsRate;

@Service
public class ForecastService {
	@Autowired
	public CdcClientService cdcClientService;
	List<CdcData> rawData;
	
	@PostConstruct
    public void init() 	
	{// using post construct  block but gemfire is recommanded to cache this data
		rawData = cdcClientService.getCDCData();		
		
	}

	public List<CdcData> getCDCRawData() {
		return cdcClientService.getCDCData();
		
	}
	
	public List<ForecastData> getForecastData() {
		List<ForecastData> forecastData = new ArrayList<ForecastData>();
		// for jan 
		String jan = "1";
		ForecastData forecastDataJan = this.getCurrentAveByMonth(jan);
		forecastData.add(forecastDataJan);
		// for feb 

		String feb = "2";
		ForecastData forecastDataFeb = this.getCurrentAveByMonth(feb);
		forecastData.add(forecastDataFeb);
		// for mar 
		/*
		 * List<CdcData> marData = this.getDataByMonth("3"); 
		 * List<CdcData> marchData = this.getDataByMonth("03");
			marchData.addAll(marData);
		 */
		// for apr 
		String mar = "3";
		ForecastData forecastDataMar = this.getCurrentAveByMonth(mar);
		forecastData.add(forecastDataMar);
		String apr = "4";
		ForecastData forecastDataApr = this.getCurrentAveByMonth(apr);
		forecastData.add(forecastDataApr);
		ForecastData forecastDataAprTenX = this.getTenTimesAveApril(apr);
		forecastData.add(forecastDataAprTenX);
		ForecastData forecastDataMayTenX = this.getTenTimesAveByMonth(apr);
		forecastData.add(forecastDataMayTenX);
		// for may 
		return forecastData;
	}
	
	public ForecastData getCurrentAveByMonth(String month) {
		List<CdcData> monthlyData =  this.getDataByMonth(month);
		
		Double avgMonthlyTests = monthlyData.stream().map(data -> Double.parseDouble(data.getDailyTotal())).collect(Collectors.averagingDouble(Double::doubleValue));   
		ForecastData forecastData = new ForecastData();
		forecastData.setAvgMonthlyTests(avgMonthlyTests.intValue());
		forecastData.setMonth(month);
		forecastData.setRate(TestsRate.CURRENT);
		return forecastData;
	}
	
	public ForecastData getTenTimesAveByMonth(String month) {
		List<CdcData> monthlyData =  this.getDataByMonth(month);
		
		Double avgMonthlyTests = monthlyData.stream().map(data -> Double.parseDouble(data.getDailyTotal())).collect(Collectors.averagingDouble(Double::doubleValue));   
		ForecastData forecastData = new ForecastData();
		forecastData.setAvgMonthlyTests(avgMonthlyTests.intValue() * 10);
		forecastData.setMonth(month);
		forecastData.setRate(TestsRate.TEN_X);
		return forecastData;
	}
	
	public ForecastData getTenTimesAveApril(String month) {
		List<CdcData> monthlyData =  this.getDataByMonth(month);
		
		Double avgMonthlyTests = monthlyData.stream().map(data -> Double.parseDouble(data.getDailyTotal())).collect(Collectors.averagingDouble(Double::doubleValue));   
		ForecastData forecastData = new ForecastData();
		forecastData.setAvgMonthlyTests(Double.valueOf(avgMonthlyTests + avgMonthlyTests*10*23/30).intValue());
		forecastData.setMonth(month);
		forecastData.setRate(TestsRate.TEN_X);
		return forecastData;
	}
	public List<CdcData> getDataByMonth(String month) {
		return rawData.stream().filter(data -> data.getDateCollected().startsWith(month)).collect(Collectors.toList());    
	}

}
