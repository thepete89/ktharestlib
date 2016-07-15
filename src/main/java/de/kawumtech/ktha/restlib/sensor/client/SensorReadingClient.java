package de.kawumtech.ktha.restlib.sensor.client;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;

import de.kawumtech.ktha.restlib.api.client.AbstractRestClient;
import de.kawumtech.ktha.restlib.sensor.pojo.SensorReading;

public class SensorReadingClient extends AbstractRestClient
{

	@Override
	public void init(String restEndpoint)
	{
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(2500);
		requestFactory.setReadTimeout(2500);
		requestFactory.setConnectionRequestTimeout(2500);
		this.restTemplate.setRequestFactory(requestFactory);
		this.restEndpoint = restEndpoint;
	}
	
	public void sendNumericReading(Double reading, String sensorName) throws RestClientException
	{
		SensorReading<Double> sensorReading = new SensorReading<Double>();
		sensorReading.setSensorName(sensorName);
		sensorReading.setValue(reading);
		this.restTemplate.postForObject(this.restEndpoint + "/api/accept/numeric", sensorReading, Void.class);
	}
	
	public void sendBooleanReading(Boolean reading, String sensorName) throws RestClientException
	{
		SensorReading<Boolean> sensorReading = new SensorReading<Boolean>();
		sensorReading.setSensorName(sensorName);
		sensorReading.setValue(reading);
		this.restTemplate.postForObject(this.restEndpoint + "/api/accept/boolean", sensorReading, Void.class);
	}
}
