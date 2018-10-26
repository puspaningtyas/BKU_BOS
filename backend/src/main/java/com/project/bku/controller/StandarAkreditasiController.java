package com.project.bku.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.StandarAkreditasi;

@RestController
@RequestMapping("/api/standarakreditasi")
public class StandarAkreditasiController extends GenericController<StandarAkreditasi, Long> {

	private static final long serialVersionUID = 8984715626372941511L;
	
	public StandarAkreditasiController() {
		super(StandarAkreditasi.class);
	}	

}
