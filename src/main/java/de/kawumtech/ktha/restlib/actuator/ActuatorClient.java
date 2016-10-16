package de.kawumtech.ktha.restlib.actuator;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import de.kawumtech.ktha.restlib.api.client.AbstractRestClient;

public class ActuatorClient extends AbstractRestClient
{
	private static final ActuatorClient INSTANCE = new ActuatorClient();
	
	private ActuatorClient()
	{}
	
	public static ActuatorClient getInstance()
	{
		return ActuatorClient.INSTANCE;
	}
	
	public void switchOn(final String actuator)
	{
		try
		{
			this.createClient(ActuatorService.class).switchOn(actuator).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}
	
	public void switchOff(final String actuator)
	{
		try
		{
			this.createClient(ActuatorService.class).switchOff(actuator).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}	
	}
	
	public void setValue(final String actuator, final Object value)
	{
		try
		{
			this.createClient(ActuatorService.class).setValue(actuator, value).execute();
		} catch (IOException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}
}
