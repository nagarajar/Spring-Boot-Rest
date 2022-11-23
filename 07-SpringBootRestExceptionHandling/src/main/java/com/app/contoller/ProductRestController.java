package com.app.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Product;
import com.app.exception.ProductNotFoundException;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController 
{
	@Autowired
	private ProductService service;
	
	/*
	@GetMapping("/one/{id}")
	public ResponseEntity<String> getProductById(@PathVariable Integer id){
		if(id == 101) {
			return new ResponseEntity<String>("Product Exist", HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product Not Found = "+id);
		}
			
	}*/
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id)
	{
		ResponseEntity<Product> response = null; 
		try {
			Product pob = service.getOneProductById(id);
			response = new ResponseEntity<Product>(pob, HttpStatus.OK);
		} catch ( ProductNotFoundException pnfe) {
			pnfe.printStackTrace();
			throw pnfe;
		}
		
		return response;
		
	}
}
