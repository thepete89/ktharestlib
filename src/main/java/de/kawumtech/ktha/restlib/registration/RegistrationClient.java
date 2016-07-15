package de.kawumtech.ktha.restlib.registration;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;

import de.kawumtech.ktha.restlib.api.client.AbstractRestClient;

public class RegistrationClient extends AbstractRestClient
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
	
	public RegistrationState registerSensor(String sensorName)
	{
		RegistrationState state = RegistrationState.UNDEFINED;
		try
		{			
			ResponseEntity<RegistrationState> response = this.restTemplate.getForEntity(this.restEndpoint + "/api/register/" + sensorName, RegistrationState.class);
			state = response.getBody();
		} catch (RestClientException e)
		{
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
		return state;
	}
}
