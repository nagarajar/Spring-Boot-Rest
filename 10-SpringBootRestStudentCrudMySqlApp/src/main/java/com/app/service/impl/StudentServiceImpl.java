package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;
import com.app.repo.StudentRespository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService 
{
	@Autowired
	private StudentRespository repo;
	
	//Create Student
	public Integer saveStudent(Student s) {
		s = repo.save(s);
		return s.getStdId();
	}

	//Get One Student
	public Student getOneStudent(Integer id) {	
		return repo.findById(id)
			.orElseThrow(
					() -> new StudentNotFoundException("Student ID = '"+id+"' Not Found")
					);	
	}

	//Get All Students List
	public List<Student> getAllStudents() {
		List<Student> list = repo.findAll();
		return list;
	}

	//Update the Student if exist
	public void updateStudent(Student s) {
		if(s.getStdId() == null || !repo.existsById(s.getStdId()))
			throw new StudentNotFoundException("Student ID = '"+s.getStdId()+"' Not Found");
		else
			repo.save(s);
	}

	//Delete Student
	public void deleteStudent(Integer id) {
		repo.delete(getOneStudent(id));

	}

}
