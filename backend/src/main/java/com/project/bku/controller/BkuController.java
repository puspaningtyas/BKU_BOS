package com.project.bku.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.bku.payload.BkuDto;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.BkuService;

@RestController
@RequestMapping("/api")
public class BkuController {

	@Autowired
	BkuService bkuServiceImpl;

	@GetMapping("/bku/{id}")
	public BkuDto getById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
		BkuDto bku =  bkuServiceImpl.getById(currentUser, id);
		return bku;
	}
	
	@GetMapping("/bku")
	public List<BkuDto> getAll(@CurrentUser UserPrincipal currentUser) {
		List<BkuDto> list =  bkuServiceImpl.getAllBku(currentUser);
		return list;
	}
	
	@PostMapping("/bku")
	public BkuDto save(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody BkuDto entity) {
		return bkuServiceImpl.save(currentUser, entity);
	}
	
	@PutMapping("/bku")
	public BkuDto update(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody BkuDto entity) {
		return bkuServiceImpl.update(currentUser, entity);
	}
	
	@DeleteMapping("/bku/{id}")
	public void delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
		bkuServiceImpl.delete(currentUser, id);
	}
}