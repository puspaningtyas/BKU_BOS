package com.project.bku.converter.impl;

import org.springframework.stereotype.Service;

import com.project.bku.converter.SekolahConverter;
import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;

@Service
public class SekolahConverterImpl implements SekolahConverter{

	@Override
	public Sekolah toModel(SekolahDto param) {
		Sekolah result = new Sekolah();
		result.setId(param.getId());
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
		return result;
	}

	@Override
	public SekolahDto toDto(Sekolah param) {
		SekolahDto result = new SekolahDto();
		result.setId(param.getId());
		result.setNamaSekolah(param.getNamaSekolah());
		result.setNpsn(param.getNpsn());
		result.setNss(param.getNss());
		result.setAlamat(param.getAlamat());
		result.setRt(param.getRt());
		result.setRw(param.getRt());
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
		return result;
	}

}
