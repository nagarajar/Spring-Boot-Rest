package com.app.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/v1/api/student")
public class StudentRestController 
{
	@Autowired
	private IStudentService service;
	
	//1. Create One Student - POST
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(
			@RequestBody @Valid Student student)
	{
		Integer id = service.saveStudent(student);
		String message = "Student '"+id+"' Created";
		
		//return new ResponseEntity<String>(message,HttpStatus.OK);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);//201-Created
	}
	
	//2. Get One Student By Id- GET
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable Integer id){
		Student s = service.getOneStudent(id);
		return ResponseEntity.ok(s);
	}
	
	//3. Get All Students List -GET
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> list = service.getAllStudents();
		return ResponseEntity.ok(list);
	}
	//4. Update Student - PUT
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student)
	{
		service.updateStudent(student);
		String message = "Student ID = '"+student.getStdId()+"' Updated";
		
		//return new ResponseEntity<String>(message,HttpStatus.OK);
		return ResponseEntity.ok(message);//200
	}
	
	//5. Delete Student - DELETE
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
		service.deleteStudent(id);
		String message = "Student ID = '"+id+"' Deleted";
		
		//return new ResponseEntity<String>(message,HttpStatus.OK);
		return ResponseEntity.ok(message);//200
	}
}
