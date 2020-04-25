package com.cdc.covid19.forecast.model;

import com.cdc.covid19.forecast.types.TestsRate;

public class ForecastData {

	private Integer avgMonthlyTests;
	private String month;
	private TestsRate rate;
	
	public Integer getAvgMonthlyTests() {
		return avgMonthlyTests;
	}
	public void setAvgMonthlyTests(Integer avgMonthlyTests) {
		this.avgMonthlyTests = avgMonthlyTests;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public TestsRate getRate() {
		return rate;
	}
	public void setRate(TestsRate rate) {
		this.rate = rate;
	}
	
	
}
