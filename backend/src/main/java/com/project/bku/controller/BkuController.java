package com.project.bku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.Bku2018;
import com.project.bku.model.BkuMappedSuperclass;
import com.project.bku.service.BkuService;

@RestController
@RequestMapping("/api")
public class BkuController {

	@Autowired
	BkuService bkuServiceImpl;

	@GetMapping("/test")
	public List<BkuMappedSuperclass> getAll() {
		List<BkuMappedSuperclass> bku =  bkuServiceImpl.getAll();
		return bku;
	}
	
	@GetMapping("/test/{id}")
	public BkuMappedSuperclass getAll(@PathVariable(value = "id") Long id) {
		BkuMappedSuperclass bku =  bkuServiceImpl.get(id);
		return bku;
	}
	
	@GetMapping("/test/save")
	public BkuMappedSuperclass save() {
		BkuMappedSuperclass bku =  bkuServiceImpl.save(new Bku2018());
		return bku;
	}
}