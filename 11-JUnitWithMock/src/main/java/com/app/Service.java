package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.app.repo.Repository;

public class Service 
{
	private Repository repo;
	
	public Service(Repository repo) {
		this.repo = repo;
	}
	
	public List<String> getDataByLen(){
		try {
			return repo.getData().stream()
								 .filter(d -> d.length() < 5)
								 .collect(Collectors.toList());
		} catch (Exception e) {
			// TODO: handle exception
			return Arrays.asList();
		}
	}
}
