package com.app;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.yml")
public class SpringBootRestCrudMySqlExApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 1. TEST SAVE OPERATION
	 * @throws Exception 
	 */
	
	@Test
	@Disabled
	@DisplayName("TESTING STUDENT SAVE OPERATION")
	@Order(1)
	public void testCreateStudent() throws Exception {
		//1. CREATE MOCK REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.post("http://localhost:9696/v1/api/student/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"stdName\":\"Naga\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Bangalore KA\"}");
		
		//2. EXECUTE IT AND READ THE RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();
		
		//4. ASSERT RESULT
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if(response.getContentAsString().contains("CREATED")) {
			fail("STUDENT NOT CREATED...!");
		}
	}
	
	/*
	// Same above test in short
	@Test
	@DisplayName("TESTING STUDENT SAVE OPERATION IN SHORT")
	@Order(1)
	public void testCreateStudent() throws Exception {
		
		mockMvc.perform(
				post("http://localhost:9696/v1/api/student/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"stdName\":\"Naga\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Bangalore KA\"}")
				).andExpect(
						status().isCreated()
						);
		
	}*/
	
	/**
	 * 2.TEST GET ALL STUDENTS
	 * @throws Exception 
	 */
	
	@Test
	@DisplayName("TEST GET ALL STUDENTS")
	@Order(2)
	public void testGetAllStudents() throws Exception {
		//1. CREATE REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:9696/v1/api/student/all");
			
		//2. EXECUTE IT
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. READ RESPONSE
		MockHttpServletResponse response = result.getResponse();
		
		//4. ASSERT RESULT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}
	
	/**
	 * 3.TEST GET ONE STUDENT BY ID
	 * @throws Exception 
	 */
	
	
	@Test
	@DisplayName("TEST GET ONE STUDENT BY ID")
	@Order(3)
	public void testGetOneStudent() throws Exception {
		//1. CREATE REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
									.get("http://localhost:9696/v1/api/student/find/{id}",10);
			
		//2. EXECUTE IT
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. READ RESPONSE
		MockHttpServletResponse response = result.getResponse();
		
		//4. ASSERT RESULT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}
	
	/**
	 * 1. TEST UPDATE OPERATION
	 * @throws Exception 
	 */
	
	@Test
	@DisplayName("TESTING STUDENT UPDATE OPERATION")
	@Order(4)
	public void testUpdateStudent() throws Exception {
		//1. CREATE MOCK REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.put("http://localhost:9696/v1/api/student/modify")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"stdId\":10,\"stdName\":\"Naga\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Bangalore KA\"}");
		
		//2. EXECUTE IT AND READ THE RESULT(REQUEST + RESPONSE + EXCEPTION)
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. READ RESPONSE FROM RESULT
		MockHttpServletResponse response = result.getResponse();
		
		//4. ASSERT RESULT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		if(response.getContentAsString().contains("UPDATED")) {
			fail("STUDENT NOT UPDATED...!");
		}
	}
	
	/**
	 * 3.TEST DELETE STUDENT BY ID
	 * @throws Exception 
	 */
	
	
	@Test
	@DisplayName("TEST DELETE STUDENT BY ID")
	@Order(5)
	public void testDeleteStudent() throws Exception {
		//1. CREATE REQUEST
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
									.delete("http://localhost:9696/v1/api/student/remove/{id}",9);
			
		//2. EXECUTE IT
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//3. READ RESPONSE
		MockHttpServletResponse response = result.getResponse();
		
		//4. ASSERT RESULT
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
	}
}
