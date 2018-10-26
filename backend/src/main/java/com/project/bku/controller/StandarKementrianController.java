package com.project.bku.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.StandarKementrian;

@RestController
@RequestMapping("/api/standarkementrian")
public class StandarKementrianController extends GenericController<StandarKementrian, Long>{

	private static final long serialVersionUID = 4236821601613761155L;

	public StandarKementrianController() {
		super(StandarKementrian.class);
	}

}
