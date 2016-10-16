package de.kawumtech.ktha.restlib.sensor.client;

import java.util.List;

import de.kawumtech.ktha.restlib.sensor.pojo.SensorReading;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SensorReadingService
{
	@POST("/api/accept/numeric")
	Call<Void> sendNumericReading(@Body SensorReading<Double> reading);
	
	@POST("/api/accept/boolean")
	Call<Void> sendBooleanReading(@Body SensorReading<Boolean> reading);
	
	@SuppressWarnings("rawtypes")
	@POST("/api/accept/multiple")
	Call<Void> sendMultipleReadings(@Body List<SensorReading> readings);
}
