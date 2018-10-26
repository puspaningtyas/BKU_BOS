package com.project.bku.payload;

public class SekolahDto {
	
	private String namaSekolah;

	private String npsn;

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

	public SekolahDto() {
	}

	public SekolahDto(String namaSekolah, String npsn, String nss, String alamat, String rT, String rW,
			String dusun, String desaKelurahan, String kecamatan, String kabupatenKota, String provinsi, String kodePos,
			String noRekening, String namaBank, String npwp, String email) {
		super();
		this.namaSekolah = namaSekolah;
		this.npsn = npsn;
		this.nss = nss;
		this.alamat = alamat;
		this.rt = rT;
		this.rw = rW;
		this.dusun = dusun;
		this.desaKelurahan = desaKelurahan;
		this.kecamatan = kecamatan;
		this.kabupatenKota = kabupatenKota;
		this.provinsi = provinsi;
		this.kodePos = kodePos;
		this.noRekening = noRekening;
		this.namaBank = namaBank;
		this.npwp = npwp;
		this.email = email;
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
