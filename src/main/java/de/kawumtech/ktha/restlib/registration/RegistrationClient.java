package de.kawumtech.ktha.restlib.registration;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import de.kawumtech.ktha.restlib.api.client.AbstractRestClient;
import retrofit2.Response;

public class RegistrationClient extends AbstractRestClient
{
	private static final RegistrationClient INSTANCE = new RegistrationClient();
	
	private RegistrationClient()
	{}
	
	public static RegistrationClient getInstance()
	{
		return RegistrationClient.INSTANCE;
	}
	
	public RegistrationState registerSensor(String sensorName)
	{
		RegistrationState state = RegistrationState.UNDEFINED;
		try
		{
			Response<RegistrationState> response = this.createClient(RegistrationService.class).registerSensor(sensorName).execute();
			state = response.body();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
		return state;
	}
	
	public RegistrationState registerActuator(String actuatorName)
	{
		RegistrationState state = RegistrationState.UNDEFINED;
		try
		{
			Response<RegistrationState> response = this.createClient(RegistrationService.class).registerActuator(actuatorName).execute();
			state = response.body();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
		return state;
	}
}
