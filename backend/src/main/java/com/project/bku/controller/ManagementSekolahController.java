package com.project.bku.controller;

import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.ManajemenSekolahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.ManajemenSekolahDto;


@RestController
@RequestMapping("/api/manajemensekolah")
public class ManagementSekolahController {

	@Autowired
	ManajemenSekolahService manajemenSekolahService;

	@PostMapping
	public Sekolah save(@CurrentUser UserPrincipal currentUser, @RequestBody ManajemenSekolahDto manajemenSekolahDto) {
		return manajemenSekolahService.save(currentUser, manajemenSekolahDto);
	}
}
