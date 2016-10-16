package de.kawumtech.ktha.restlib.registration;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RegistrationService
{
	@GET("/api/register/sensor/{sensorName}")
	Call<RegistrationState> registerSensor(@Path("sensorName") String sensorName);
	
	@GET("/api/register/actuator/{actuatorName}")
	Call<RegistrationState> registerActuator(@Path("actuatorName") String actuatorName);
}
