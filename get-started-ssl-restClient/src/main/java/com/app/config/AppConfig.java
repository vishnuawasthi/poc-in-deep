package com.app.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Collections;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	private String password ="admin@123";
	String plainCreds = "vishnuawasthi:password";
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException,
			CertificateException, FileNotFoundException, IOException {

		SSLContext sslContext = SSLContextBuilder.create()
				.loadTrustMaterial(ResourceUtils.getFile("classpath:sslkeys/keystore.jks"), password.toCharArray())
				.build();

		CloseableHttpClient client = HttpClients.custom().setSSLContext(sslContext).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(client);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.setInterceptors(Collections.singletonList(clientHttpRequestInterceptor()));
		return restTemplate;
	}
	
	public ClientHttpRequestInterceptor clientHttpRequestInterceptor() {
		ClientHttpRequestInterceptor interceptor = new ClientHttpRequestInterceptor() {
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
					throws IOException {
				HttpHeaders headers = request.getHeaders();
				byte[] plainCredsBytes = plainCreds.getBytes();
				byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
				String base64Creds = new String(base64CredsBytes);
				headers.add("Authorization", "Basic " + base64Creds);
				headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
				return execution.execute(request, body);
			}
		};
		return interceptor;
	}
}
