package com.project.bku.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sekolah")
public class Sekolah {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String namaSekolah;
	
	private String npsn;
	
	private String nss;
	
	private String alamat;
	
	private String RT;
	
	private String RW;
	
	private String dusun;
	
	private String desaKelurahan;
	
	private String kecamatan;
	
	private String kabupatenKota;
	
	private String provinsi;
	
	private String kodePos;
	
	private String noRekening;
	
	private String namaBank;
	
	private String npwp;
	
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "management_sekolah_id")
	private ManagemenSekolah managementSekolah;
	
	public ManagemenSekolah getManagementSekolah() {
		return managementSekolah;
	}

	public void setManagementSekolah(ManagemenSekolah managementSekolah) {
		this.managementSekolah = managementSekolah;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaSekolah() {
		return namaSekolah;
	}

	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}

	public String getNpsn() {
		return npsn;
	}

	public void setNpsn(String npsn) {
		this.npsn = npsn;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getRT() {
		return RT;
	}

	public void setRT(String rT) {
		RT = rT;
	}

	public String getRW() {
		return RW;
	}

	public void setRW(String rW) {
		RW = rW;
	}

	public String getDusun() {
		return dusun;
	}

	public void setDusun(String dusun) {
		this.dusun = dusun;
	}

	public String getDesaKelurahan() {
		return desaKelurahan;
	}

	public void setDesaKelurahan(String desaKelurahan) {
		this.desaKelurahan = desaKelurahan;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getKabupatenKota() {
		return kabupatenKota;
	}

	public void setKabupatenKota(String kabupatenKota) {
		this.kabupatenKota = kabupatenKota;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getKodePos() {
		return kodePos;
	}

	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	public String getNamaBank() {
		return namaBank;
	}

	public void setNamaBank(String namaBank) {
		this.namaBank = namaBank;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
