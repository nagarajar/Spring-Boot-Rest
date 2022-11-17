package com.app.nagu.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductRestController 
{
	//Using RequestParm
	//Url => "http://localhost:8080/product/dataa?id=10&name=nagaraja 
	@PostMapping("/dataa")
	public ResponseEntity<String> showDataA(
			@RequestParam("id") Integer id,
			@RequestParam("name") String name)
	{
		System.out.println("Data: Id = "+id+"and Name = "+name);
		ResponseEntity<String> response = new ResponseEntity<String>("Data: Id = "+id+" and Name = "+name, HttpStatus.OK);
		return response;
	}
	
	//Using PathVariable
	//Url => "http://localhost:8080/product/dataa/11/Kiran
	@PostMapping("/dataa/{pid}/{pname}")
	public ResponseEntity<String> showDataB(
			@PathVariable("pid") Integer id,
			@PathVariable("pname") String name)
	{
		System.out.println("Data: Id = "+id+"and Name = "+name);
		ResponseEntity<String> response = new ResponseEntity<String>("Data: Id = "+id+" and Name = "+name, HttpStatus.OK);
		return response;
	}
	
	//Using RequestHeader
	//Url => "http://localhost:8080/product/details
	//In Postman add body then you will get headers like { "pId":10 }
	@PostMapping("/details")
	public ResponseEntity<String> showHeaders(
			@RequestHeader("Content-Type") String type,
			@RequestHeader("Content-Length") String length,
			//passing custom headers
			@RequestHeader("Authorization")String auth,
			
			HttpServletRequest req)
	{
		System.out.println("Headers: Type = "+type+" and Length = "+length+" and Auth = "+auth);
		System.out.println("**************************************************");
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String hdr = headerNames.nextElement();
			System.out.println(hdr + " " + req.getHeader(hdr));
		}
		System.out.println("**************************************************");
		ResponseEntity<String> response = new ResponseEntity<String>("Headers: Type = "+type+" and Length = "+length+" and Auth = "+auth, HttpStatus.OK);
		return response;
	}
}
