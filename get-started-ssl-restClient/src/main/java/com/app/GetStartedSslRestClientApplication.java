package com.app;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetStartedSslRestClientApplication  implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GetStartedSslRestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String plainCreds = "vishnuawasthi:password";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Authorization", "Basic " + base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		String url  ="https://localhost:8090/wellness-mngt/admin-api/v1/country-details";
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
		String countriesDetails = response.getBody();
		System.out.println("countriesDetails   -> "+countriesDetails);
		
	}

}
