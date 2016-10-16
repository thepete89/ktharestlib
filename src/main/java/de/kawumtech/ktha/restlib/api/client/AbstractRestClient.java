package de.kawumtech.ktha.restlib.api.client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public abstract class AbstractRestClient
{
	private OkHttpClient.Builder httpClient = null;

	private RestConfiguration configuration = null;

	public <T> T createClient(final Class<T> serviceClass) throws RestConfigurationException
	{
		return this.createClient(serviceClass, this.configuration);
	}

	public <T> T createClient(final Class<T> serviceClass, final RestConfiguration configuration) throws RestConfigurationException
	{
		this.checkConfiguration(configuration);
		return this.createBuilder(configuration).client(this.setupClient(configuration)).build()
				.create(serviceClass);
	}

	private OkHttpClient setupClient(RestConfiguration configuration)
	{
		if (this.httpClient == null)
		{
			this.httpClient = new OkHttpClient.Builder();
			this.setReadTimeout(configuration);
			this.setConnectTimeout(configuration);
		}
		return this.httpClient.build();
	}

	private void setConnectTimeout(RestConfiguration configuration)
	{
		if (configuration.getConnectTimeout() > 0)
		{
			this.httpClient.connectTimeout(configuration.getConnectTimeout(),
					configuration.getConnectTimeoutTimeunit() != null
							? configuration.getConnectTimeoutTimeunit() : TimeUnit.MILLISECONDS);
		}
	}

	private void setReadTimeout(RestConfiguration configuration)
	{
		if (configuration.getReadTimeout() > 0)
		{
			this.httpClient.readTimeout(configuration.getReadTimeout(),
					configuration.getReadTimeoutTimeunit() != null
							? configuration.getReadTimeoutTimeunit() : TimeUnit.MILLISECONDS);
		}
	}

	private Retrofit.Builder createBuilder(RestConfiguration configuration)
	{
		return new Retrofit.Builder().baseUrl(this.correctServiceEndpoint(configuration))
				.addConverterFactory(JacksonConverterFactory.create());
	}

	private String correctServiceEndpoint(RestConfiguration configuration)
	{
		String serviceEndpoint = configuration.getServiceEndpoint();
		if (serviceEndpoint != null && !serviceEndpoint.endsWith("/"))
		{
			serviceEndpoint += "/";
		}
		return serviceEndpoint;
	}

	public void init(final RestConfiguration configuration)
	{
		this.configuration = configuration;
	}
	
	public RestConfiguration getConfiguration()
	{
		return this.configuration;
	}
	
	private void checkConfiguration(final RestConfiguration configuration) throws RestConfigurationException
	{
		if (configuration == null)
		{
			throw new RestConfigurationException(
					"RESTCONFIGURATION NOT FOUND! USE INIT-METHOD WITH VALID CONFIGURATION OR createService(Class<?> serviceClass, RestConfiguration configuration)!");
		}
	}
}
