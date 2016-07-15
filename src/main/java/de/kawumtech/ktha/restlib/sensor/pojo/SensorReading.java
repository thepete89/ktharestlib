package de.kawumtech.ktha.restlib.sensor.pojo;

public class SensorReading<T>
{
	private String sensorName;
	
	private T value;

	public String getSensorName()
	{
		return sensorName;
	}

	public void setSensorName(String sensorName)
	{
		this.sensorName = sensorName;
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		this.value = value;
	}
}
