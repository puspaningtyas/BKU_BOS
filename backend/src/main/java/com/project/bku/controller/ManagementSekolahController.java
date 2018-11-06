package com.project.bku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.converter.ManajemenSekolahConverter;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.ManajemenSekolah;
import com.project.bku.model.Sekolah;
import com.project.bku.payload.ManajemenSekolahDto;
import com.project.bku.repository.ManajemenSekolahRepository;
import com.project.bku.repository.SekolahRepository;

@RestController
@RequestMapping("/api/manajemensekolah")
public class ManagementSekolahController {

	@Autowired
	ManajemenSekolahRepository manajemenSekolahRepository;

	@Autowired
	SekolahRepository sekolahRepository;

	@Autowired
	ManajemenSekolahConverter manajemenSekolahConverterImpl;

	@PostMapping
	public Sekolah save(@RequestBody ManajemenSekolahDto param) {
		Sekolah sekolah = sekolahRepository.findById(param.getNpsn())
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "id", param.getNpsn()));
		ManajemenSekolah result = manajemenSekolahConverterImpl.toModel(param);
		/**
		 * Jika belum ada.
		 */
		if (sekolah.getManagementSekolah() == null) {
			sekolah.setManagementSekolah(result);
			return sekolahRepository.save(sekolah);
		/**
		 * Jika sudah ada.
		 */
		}else {
			result.setId(sekolah.getManagementSekolah().getId());
			manajemenSekolahRepository.save(result);
			return sekolah;
		}
	}
}
