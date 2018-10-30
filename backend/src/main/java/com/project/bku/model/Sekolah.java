package com.project.bku.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.project.generic.model.GenericUserDateAudit;

@Entity
@Table(name="sekolah")
public class Sekolah extends GenericUserDateAudit{
	
	private static final long serialVersionUID = -6666342282800547074L;

	@Id
    private Long npsn;
	
	private String namaSekolah;
	
	private String nss;
	
	private String alamat;
	
	private String rt;
	
	private String rw;
	
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
	private ManajemenSekolah managementSekolah;
	
	public ManajemenSekolah getManagementSekolah() {
		return managementSekolah;
	}

	public void setManagementSekolah(ManajemenSekolah managementSekolah) {
		this.managementSekolah = managementSekolah;
	}

	public String getNamaSekolah() {
		return namaSekolah;
	}

	public void setNamaSekolah(String namaSekolah) {
		this.namaSekolah = namaSekolah;
	}

	public Long getNpsn() {
		return npsn;
	}

	public void setNpsn(Long npsn) {
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

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getRw() {
		return rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
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
