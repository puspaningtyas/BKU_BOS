package com.project.bku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.converter.SekolahConverter;
import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.repository.ManajemenSekolahRepository;
import com.project.bku.repository.SekolahRepository;

@RestController
@RequestMapping("/api/sekolah")
public class SekolahController {
	
	@Autowired
	SekolahRepository sekolahRepostory;
	
	@Autowired
	ManajemenSekolahRepository managemenSekolahRepository;
	
	@Autowired
	SekolahConverter sekolahConverterImpl;
	
	@PostMapping
	public Sekolah save(@RequestBody SekolahDto sekolah) {
		Sekolah sek = new Sekolah();
		sek = sekolahConverterImpl.toModel(sekolah);
		Sekolah result = sekolahRepostory.save(sek);
		return result;
	}
}
