package com.project.bku.converter.impl;

import org.springframework.stereotype.Service;

import com.project.bku.converter.Bku2018Converter;
import com.project.bku.model.Bku2018;
import com.project.bku.payload.BkuDto;

@Service
public class Bku2018ConverterImpl implements Bku2018Converter{

	@Override
	public Bku2018 toModel(BkuDto param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BkuDto toDto(Bku2018 param) {
		BkuDto result = new BkuDto();
		result.setNoKode(param.getNoKode());
		return result;
	}

}
