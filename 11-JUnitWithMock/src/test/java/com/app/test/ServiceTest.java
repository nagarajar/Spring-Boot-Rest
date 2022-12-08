package com.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.Service;
import com.app.repo.Repository;


//Activate JUnit with Mock
@ExtendWith(MockitoExtension.class)
public class ServiceTest 
{
	// One dummy object is created by Mockito
	@Mock
	private Repository repo;
	
	// it will find all dependencies and inject them (like Autowired)
	@InjectMocks
	private Service service;
	
	@Test
	public void testSuccess() {
		try {
			// dummy implement given using Mocking
			when(repo.getData()).thenReturn(Arrays.asList("A","B","Raghu","12345","1234"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// Test using JUnit
		List<String> actual = service.getDataByLen();
		assertNotNull(actual);
		assertEquals(3, actual.size());
	}
	
	@Test
	public void testException() {
		try {
			// dummy implement given using Mocking
			when(repo.getData()).thenThrow(new SQLException("Connection Issue"));
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// Test using JUnit
		List<String> actual = service.getDataByLen();
		assertNotNull(actual);
		assertEquals(0, actual.size());
	}
}
