package com.project.bku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.converter.SekolahConverter;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.repository.ManajemenSekolahRepository;
import com.project.bku.repository.SekolahRepository;

@RestController
@RequestMapping("/api/sekolah")
public class SekolahController {
	
	@Autowired
	SekolahRepository sekolahRepository;
	
	@Autowired
	ManajemenSekolahRepository managemenSekolahRepository;
	
	@Autowired
	SekolahConverter sekolahConverterImpl;
	
	@GetMapping
	public List<Sekolah> getAll(){
		return sekolahRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Sekolah getById(@PathVariable(value = "id") Long id) {
		Sekolah sekolah = sekolahRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "id", id));
		return sekolah;
	}
	
	@PostMapping
	public Sekolah save(@RequestBody SekolahDto sekolah) {
		Sekolah sek = new Sekolah();
		sek = sekolahConverterImpl.toModel(sekolah);
		Sekolah result = sekolahRepository.save(sek);
		return result;
	}
	
	@PutMapping
	public Sekolah update(@RequestBody SekolahDto param) {
		Sekolah result = sekolahRepository.findById(param.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "id", param.getId()));
		result.setNamaSekolah(param.getNamaSekolah());
		result.setNpsn(param.getNpsn());
		result.setNss(param.getNss());
		result.setAlamat(param.getAlamat());
		result.setRt(param.getRt());
		result.setRw(param.getRw());
		result.setDusun(param.getDusun());
		result.setDesaKelurahan(param.getDesaKelurahan());
		result.setKecamatan(param.getKecamatan());
		result.setKabupatenKota(param.getKabupatenKota());
		result.setProvinsi(param.getProvinsi());
		result.setKodePos(param.getKodePos());
		result.setNoRekening(param.getNoRekening());
		result.setNamaBank(param.getNamaBank());
		result.setNpwp(param.getNpwp());
		result.setEmail(param.getEmail());
		return sekolahRepository.save(result);
	}
}
