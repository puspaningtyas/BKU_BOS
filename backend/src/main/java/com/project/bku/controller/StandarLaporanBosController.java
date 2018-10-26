package com.project.bku.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.StandarLaporanBos;

@RestController
@RequestMapping("/api/standarlaporanbos")
public class StandarLaporanBosController extends GenericController<StandarLaporanBos, Long>{

	private static final long serialVersionUID = -9220886177056071302L;

	public StandarLaporanBosController() {
		super(StandarLaporanBos.class);
	}

}
