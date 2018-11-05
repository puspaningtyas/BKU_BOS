package com.project.bku.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "management_sekolah")
public class ManajemenSekolah {

	private static final String TIMEZONE = "Asia/Jakarta";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String namaKepalaSekolah;

	private String nipKepalaSekolah;

	private String namaKetuaKomiteSekolah;

	private String namaBendahara;

	private String nipBendahara;

	private String alamatRumahKepalaSekolah;

	private String nomorSkKepalaSekolah;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone=TIMEZONE)
	private Date tanggalSkKepalaSekolah;

	private String nomorSkBendaharaBos;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone=TIMEZONE)
	private Date tanggalSkBendaharaBos;

	private String namaKetuaTimBosKabupaten;

	private String nipKetuaTimBosKabupaten;

	private String namaKepalaUptDisdikbud;

	private String nipKepalaUptDisdikbud;

	@JsonIgnore
	@OneToOne(mappedBy = "managementSekolah")
	private Sekolah sekolah;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaKepalaSekolah() {
		return namaKepalaSekolah;
	}

	public void setNamaKepalaSekolah(String namaKepalaSekolah) {
		this.namaKepalaSekolah = namaKepalaSekolah;
	}

	public String getNipKepalaSekolah() {
		return nipKepalaSekolah;
	}

	public void setNipKepalaSekolah(String nipKepalaSekolah) {
		this.nipKepalaSekolah = nipKepalaSekolah;
	}

	public String getNamaKetuaKomiteSekolah() {
		return namaKetuaKomiteSekolah;
	}

	public void setNamaKetuaKomiteSekolah(String namaKetuaKomiteSekolah) {
		this.namaKetuaKomiteSekolah = namaKetuaKomiteSekolah;
	}

	public String getNamaBendahara() {
		return namaBendahara;
	}

	public void setNamaBendahara(String namaBendahara) {
		this.namaBendahara = namaBendahara;
	}

	public String getNipBendahara() {
		return nipBendahara;
	}

	public void setNipBendahara(String nipBendahara) {
		this.nipBendahara = nipBendahara;
	}

	public String getAlamatRumahKepalaSekolah() {
		return alamatRumahKepalaSekolah;
	}

	public void setAlamatRumahKepalaSekolah(String alamatRumahKepalaSekolah) {
		this.alamatRumahKepalaSekolah = alamatRumahKepalaSekolah;
	}

	public String getNomorSkKepalaSekolah() {
		return nomorSkKepalaSekolah;
	}

	public void setNomorSkKepalaSekolah(String nomorSkKepalaSekolah) {
		this.nomorSkKepalaSekolah = nomorSkKepalaSekolah;
	}

	public Date getTanggalSkKepalaSekolah() {
		return tanggalSkKepalaSekolah;
	}

	public void setTanggalSkKepalaSekolah(Date tanggalSkKepalaSekolah) {
		this.tanggalSkKepalaSekolah = tanggalSkKepalaSekolah;
	}

	public String getNomorSkBendaharaBos() {
		return nomorSkBendaharaBos;
	}

	public void setNomorSkBendaharaBos(String nomorSkBendaharaBos) {
		this.nomorSkBendaharaBos = nomorSkBendaharaBos;
	}

	public Date getTanggalSkBendaharaBos() {
		return tanggalSkBendaharaBos;
	}

	public void setTanggalSkBendaharaBos(Date tanggalSkBendaharaBos) {
		this.tanggalSkBendaharaBos = tanggalSkBendaharaBos;
	}

	public String getNamaKetuaTimBosKabupaten() {
		return namaKetuaTimBosKabupaten;
	}

	public void setNamaKetuaTimBosKabupaten(String namaKetuaTimBosKabupaten) {
		this.namaKetuaTimBosKabupaten = namaKetuaTimBosKabupaten;
	}

	public String getNipKetuaTimBosKabupaten() {
		return nipKetuaTimBosKabupaten;
	}

	public void setNipKetuaTimBosKabupaten(String nipKetuaTimBosKabupaten) {
		this.nipKetuaTimBosKabupaten = nipKetuaTimBosKabupaten;
	}

	public String getNamaKepalaUptDisdikbud() {
		return namaKepalaUptDisdikbud;
	}

	public void setNamaKepalaUptDisdikbud(String namaKepalaUptDisdikbud) {
		this.namaKepalaUptDisdikbud = namaKepalaUptDisdikbud;
	}

	public String getNipKepalaUptDisdikbud() {
		return nipKepalaUptDisdikbud;
	}

	public void setNipKepalaUptDisdikbud(String nipKepalaUptDisdikbud) {
		this.nipKepalaUptDisdikbud = nipKepalaUptDisdikbud;
	}

	
}
