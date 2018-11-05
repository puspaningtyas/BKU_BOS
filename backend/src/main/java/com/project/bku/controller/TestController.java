package com.project.bku.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.Bku2018;
import com.project.bku.payload.BkuDto;
import com.project.bku.repository.RepositoryBku2018;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	RepositoryBku2018 repositoryBku2018;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping
	public List<BkuDto> get(@CurrentUser UserPrincipal currentUser) {
		List<Bku2018> list = repositoryBku2018.findAllByNisn(Long.valueOf("7985410241124"));
		List<BkuDto> bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
		return bku;
	}
}
