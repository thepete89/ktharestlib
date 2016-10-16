package de.kawumtech.ktha.restlib.api.client;

import java.util.concurrent.TimeUnit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestConfiguration
{
	private String serviceEndpoint;
	
	private long connectTimeout;
	
	private TimeUnit connectTimeoutTimeunit;
	
	private long readTimeout;
	
	private TimeUnit readTimeoutTimeunit;
}
