package de.kawumtech.ktha.restlib.actuator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ActuatorService
{
	@GET("/switch/on/{actuator}")
	Call<Void> switchOn(@Path("actuator") String actuator);
	
	@GET("/switch/off/{actuator}")
	Call<Void> switchOff(@Path("actuator") String actuator);
	
	@GET("/switch/set/{actuator}/{value}")
	Call<Void> setValue(@Path("actuator") String actuator, @Path("value") Object value);
}
