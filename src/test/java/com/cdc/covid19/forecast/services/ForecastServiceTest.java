package com.cdc.covid19.forecast.services;


import java.util.List;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@RunWith(MockitoJUnitRunner.class)
public class ForecastServiceTest {
	@Autowired
	public CdcClientService cdcClientService;
	public List<?> getAveByMonth() {
		cdcClientService.getCDCData();
		return null;
		
	}

}
