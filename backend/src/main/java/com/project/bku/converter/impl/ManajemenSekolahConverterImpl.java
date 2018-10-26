package com.project.bku.converter.impl;

import org.springframework.stereotype.Service;

import com.project.bku.converter.ManajemenSekolahConverter;
import com.project.bku.model.ManajemenSekolah;
import com.project.bku.payload.ManajemenSekolahDto;

@Service
public class ManajemenSekolahConverterImpl implements ManajemenSekolahConverter{

	@Override
	public ManajemenSekolah toModel(ManajemenSekolahDto param) {
		ManajemenSekolah result = new ManajemenSekolah();
		result.setNamaKepalaSekolah(param.getNamaKepalaSekolah());
		result.setNipKepalaSekolah(param.getNipKepalaSekolah());
		result.setNamaKetuaKomiteSekolah(param.getNamaKetuaKomiteSekolah());
		result.setNamaBendahara(param.getNamaBendahara());
		result.setNipBendahara(param.getNipBendahara());
		result.setAlamatRumahKepalaSekolah(param.getAlamatRumahKepalaSekolah());
		result.setNomorSkKepalaSekolah(param.getNomorSkKepalaSekolah());
		result.setTanggalSkKepalaSekolah(param.getTanggalSkKepalaSekolah());
		result.setNomorSkBendaharaBos(param.getNomorSkBendaharaBos());
		result.setTanggalSkBendaharaBos(param.getTanggalSkBendaharaBos());
		result.setNamaKetuaTimBosKabupaten(param.getNamaKetuaTimBosKabupaten());
		result.setNipKetuaTimBosKabupaten(param.getNipKetuaTimBosKabupaten());
		result.setNamaKepalaUptDisdikbud(param.getNamaKepalaUptDisdikbud());
		result.setNipKepalaUptDisdikbud(param.getNipKepalaUptDisdikbud());
		return result;
	}

	@Override
	public ManajemenSekolahDto toDto(ManajemenSekolah param) {
		ManajemenSekolahDto result = new ManajemenSekolahDto();
		result.setNamaKepalaSekolah(param.getNamaKepalaSekolah());
		result.setNipKepalaSekolah(param.getNipKepalaSekolah());
		result.setNamaKetuaKomiteSekolah(param.getNamaKetuaKomiteSekolah());
		result.setNamaBendahara(param.getNamaBendahara());
		result.setNipBendahara(param.getNipBendahara());
		result.setAlamatRumahKepalaSekolah(param.getAlamatRumahKepalaSekolah());
		result.setNomorSkKepalaSekolah(param.getNomorSkKepalaSekolah());
		result.setTanggalSkKepalaSekolah(param.getTanggalSkKepalaSekolah());
		result.setNomorSkBendaharaBos(param.getNomorSkBendaharaBos());
		result.setTanggalSkBendaharaBos(param.getTanggalSkBendaharaBos());
		result.setNamaKetuaTimBosKabupaten(param.getNamaKetuaTimBosKabupaten());
		result.setNipKetuaTimBosKabupaten(param.getNipKetuaTimBosKabupaten());
		result.setNamaKepalaUptDisdikbud(param.getNamaKepalaUptDisdikbud());
		result.setNipKepalaUptDisdikbud(param.getNipKepalaUptDisdikbud());
		return result;
	}

}
