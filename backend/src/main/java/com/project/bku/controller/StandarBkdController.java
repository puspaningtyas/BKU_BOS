package com.project.bku.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.StandarBkd;

@RestController
@RequestMapping("/api/standarbkd")
public class StandarBkdController extends GenericController<StandarBkd, Long>{

	private static final long serialVersionUID = -3319035459987783885L;
	
	public StandarBkdController() {
		super(StandarBkd.class);
	}
	
}
