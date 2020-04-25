package com.cdc.covid19.forecast.model;

public class CdcData {
	private String dateCollected;
	private String cdcLabs;
	private String usPubHealthLabs;
	private String dailyTotal;
	private String lag;
	public String getDateCollected() {
		return dateCollected;
	}
	public void setDateCollected(String dateCollected) {
		this.dateCollected = dateCollected;
	}
	public String getCdcLabs() {
		return cdcLabs;
	}
	public void setCdcLabs(String cdcLabs) {
		this.cdcLabs = cdcLabs;
	}
	public String getUsPubHealthLabs() {
		return usPubHealthLabs;
	}
	public void setUsPubHealthLabs(String usPubHealthLabs) {
		this.usPubHealthLabs = usPubHealthLabs;
	}
	public String getDailyTotal() {
		return dailyTotal;
	}
	public void setDailyTotal(String dailyTotal) {
		this.dailyTotal = dailyTotal;
	}
	public String getLag() {
		return lag;
	}
	public void setLag(String lag) {
		this.lag = lag;
	}
	
}
