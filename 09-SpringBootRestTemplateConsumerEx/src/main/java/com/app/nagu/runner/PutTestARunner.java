package com.app.nagu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class PutTestARunner implements CommandLineRunner 
{
	public void run(String... args) throws Exception {
		//1. Create URL
		String url = "http://localhost:8080/v1/api/book/showF";
		
		//2. Create Request Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//3. Create Request Body
		String body = "{\"bid\": 108,\"bname\": \"Core Java\",\"bauth\": \"Balu\",\"bcost\": 1000.0}";
		
		// (2+3)Combine Headers and Body
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
		
		//4. Create RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP Calls and Get Response back
		//Old Way
		//ResponseEntity<String> response = template.postForEntity(url, requestEntity, String.class);
		//Using Generic Method
		ResponseEntity<String> response = template.exchange(url,HttpMethod.PUT, requestEntity, String.class);
		
		//6. Print Details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());

	}
}
