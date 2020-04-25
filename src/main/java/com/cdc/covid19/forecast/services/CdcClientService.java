package com.cdc.covid19.forecast.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdc.covid19.forecast.model.CdcData;

@Service
public class CdcClientService {

	@Autowired
	public RestTemplate restTemplate;

	public List<CdcData> getCDCData() {

		try {
			String url = "http://covidtracking.com/api/cdc/daily";
			URI uri;
			uri = new URI(url);

			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-PERSIST", "true");
			headers.set("X-COM-LOCATION", "USA");

			HttpEntity<?> entity = new HttpEntity<>(headers);

			ResponseEntity<List<CdcData>> result = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<CdcData>>() {
			});
			return result.getBody();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
