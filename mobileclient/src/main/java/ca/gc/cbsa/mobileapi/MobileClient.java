package ca.gc.cbsa.mobileapi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class MobileClient {
	
	static final public int SERVER_PORT = 5000;

	
	// This is a change to be upload to Git Hub!!
	
	private String getURL() {
		
		return "http://localhost:" + SERVER_PORT + "/v1/api/trip/106";
	}
	
	private void test1() {
		System.out.println("Test 1...");
		RestTemplate restTemplate = new RestTemplate();
	     
//		final String baseUrl = "http://localhost:" + SERVER_PORT + "/employees";
		URI uri;
		try {
			uri = new URI( getURL() );
			
			System.out.println("Calling: " + getURL() + " ...");
			ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			System.out.println("\nResult:");
			System.out.println("\tHTTP code = " +  result.getStatusCodeValue());
			System.out.println("\tPayload = " + result.getBody());
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void test2() {
		System.out.println("Test 2...");
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("locale", "en");  
		 
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
	     
		URI uri = null;
		try {
			uri = new URI( getURL() );
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		     
		
		
		System.out.println("Calling: " + getURL() + " ...");
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
		     
		//Verify request succeed
		System.out.println("\nResult:");
		System.out.println("\tHTTP code = " +  result.getStatusCodeValue());
		System.out.println("\tPayload = " + result.getBody());
		
	}
	
	public static void main(String[] args) {
		new MobileClient().test2();
	}

}
