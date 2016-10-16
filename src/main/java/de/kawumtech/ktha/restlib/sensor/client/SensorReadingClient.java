package de.kawumtech.ktha.restlib.sensor.client;

import java.io.IOException;
import java.util.List;

import org.slf4j.LoggerFactory;

import de.kawumtech.ktha.restlib.api.client.AbstractRestClient;
import de.kawumtech.ktha.restlib.sensor.pojo.SensorReading;

public class SensorReadingClient extends AbstractRestClient
{
	private static final SensorReadingClient INSTANCE = new SensorReadingClient();
	
	private SensorReadingClient()
	{}
	
	public static SensorReadingClient getInstance()
	{
		return SensorReadingClient.INSTANCE;
	}
	
	public void sendNumericReading(Double reading, String sensorName)
	{
		SensorReading<Double> sensorReading = new SensorReading<Double>();
		sensorReading.setSensorName(sensorName);
		sensorReading.setValue(reading);
		try
		{
			this.createClient(SensorReadingService.class).sendNumericReading(sensorReading).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}
	
	public void sendBooleanReading(Boolean reading, String sensorName)
	{
		SensorReading<Boolean> sensorReading = new SensorReading<Boolean>();
		sensorReading.setSensorName(sensorName);
		sensorReading.setValue(reading);
		try
		{
			this.createClient(SensorReadingService.class).sendBooleanReading(sensorReading).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void sendMultipleReadings(List<SensorReading> readings)
	{
		try
		{
			this.createClient(SensorReadingService.class).sendMultipleReadings(readings).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}
}
