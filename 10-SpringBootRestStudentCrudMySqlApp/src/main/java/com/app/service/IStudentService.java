package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface IStudentService 
{
	Integer saveStudent(Student s);     // Create
	Student getOneStudent(Integer id);  // Read
	List<Student> getAllStudents();             
	void updateStudent(Student s);      // Update
	void deleteStudent(Integer id);     // Delete
}
