package com.project.bku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.repository.SekolahRepository;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.SekolahService;

@RestController
@RequestMapping("/api/sekolah")
public class SekolahController {

	@Autowired
	SekolahRepository sekolahRepository;
	
	@Autowired
	SekolahService sekolahServiceImpl;

	@GetMapping
	public List<Sekolah> getAll() {
		return sekolahRepository.findAll();
	}

	@GetMapping("/{npsn}")
	@PreAuthorize("hasRole('BENDAHARA')")
	public Sekolah getSekolah(@CurrentUser UserPrincipal currentUser, @PathVariable(value = "npsn") Long npsn) {
		return sekolahServiceImpl.getSekolah(currentUser, npsn);
	}

	@PostMapping
	@PreAuthorize("hasRole('BENDAHARA')")
	public Sekolah save(@CurrentUser UserPrincipal currentUser, @RequestBody SekolahDto sekolahDto) {
		return sekolahServiceImpl.save(currentUser, sekolahDto);
	}

	@PutMapping
	@PreAuthorize("hasRole('BENDAHARA')")
	public Sekolah update(@CurrentUser UserPrincipal currentUser, @RequestBody SekolahDto sekolahDto) {
		return sekolahServiceImpl.update(currentUser, sekolahDto);
	}
}
