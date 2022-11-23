package com.app.nagu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class DeleteTestARunner implements CommandLineRunner 
{
	public void run(String... args) throws Exception {
		//1. Create URL
		String url = "http://localhost:8080/v1/api/book/showG/{id}";
		
		//2. Create Request Headers
		//3. Create Request Body
		// (2+3)Combine Headers and Body
		
		//4. Create RestTemplate Object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP Calls and Get Response back
		//Old Way
		//ResponseEntity<String> response = template.getForEntity(url, String.class);
		//Using Generic exchange method
		ResponseEntity<String> response = template.exchange(url,HttpMethod.DELETE, null, String.class,101);
		
		//6. Print Details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());

	}
}
