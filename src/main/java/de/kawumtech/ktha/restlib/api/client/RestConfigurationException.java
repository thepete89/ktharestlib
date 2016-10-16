package de.kawumtech.ktha.restlib.api.client;

import java.io.IOException;

public class RestConfigurationException extends IOException
{
	private static final long serialVersionUID = -7968865607964816618L;

	public RestConfigurationException()
	{
		super();
	}
	
	public RestConfigurationException(String message)
	{
		super(message);
	}
}
