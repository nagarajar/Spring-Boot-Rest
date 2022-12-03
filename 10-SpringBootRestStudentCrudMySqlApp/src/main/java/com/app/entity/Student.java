package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "stdtab")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer stdId;
	
	@Column(name = "sname")
	//@NotNull(message = "Name can't be null")
	//@NotEmpty(message = "Name shouldn't be empty")
	@NotBlank(message = "Name shouldn't be blank")
	//@Size(min = 2,max = 8,message = "NAME MUST BE 2-6 CHARS ONLY")
	@Pattern(regexp = "[A-Za-z]{2,6}",message = "Only A-Z/a-z are allowed and NAME MUST BE 2-6 CHARS ONLY")
	private String stdName;
	
	@Column(name = "sgen")
	@NotBlank(message="STUDENT GENDER CAN NOT BE EMPTY")
	private String stdGen;
	
	@Column(name = "scourse")
	@NotBlank(message="STUDENT COURSE MUST BE SELECTED")
	private String stdCourse;
	
	@Column(name = "saddr")
	@Pattern(regexp = "[A-Za-z0-9\\.\\,\\ \\-\\?]{3,250}", message = "Invalid Adress Details")
	private String stdAddr;
	
}
