package de.kawumtech.ktha.restlib.api.client;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestClient
{
	protected RestTemplate restTemplate = new RestTemplate();
	
	protected String restEndpoint;
	
	public abstract void init(String restEndpoint);
}
