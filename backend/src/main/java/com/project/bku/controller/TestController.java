package com.project.bku.controller;

import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.Bku2018;
import com.project.bku.model.DBFile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.bku.repository.RepositoryBku2018;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;

import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	RepositoryBku2018 repositoryBku2018;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping
	public UserPrincipal get(@CurrentUser UserPrincipal currentUser) {
		return currentUser;
	}

	@GetMapping("/lob/{id}")
	public String lob(@PathVariable(name="id") Long id){
		return null;
	}
}
