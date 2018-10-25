package com.project.bku.payload;


public class UserProfile {

	private Long id;
	private String name;
	private String username;
	private String email;
	private String instansi;
	private String alamatInstansi;
	private String kabupaten;
	private String tahunAktif;
	
	
	public UserProfile(Long id, String name, String username, String email, String instansi,
			String alamatInstansi, String kabupaten, String tahunAktif) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.instansi = instansi;
		this.alamatInstansi = alamatInstansi;
		this.kabupaten = kabupaten;
		this.tahunAktif = tahunAktif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstansi() {
		return instansi;
	}

	public void setInstansi(String instansi) {
		this.instansi = instansi;
	}

	public String getAlamatInstansi() {
		return alamatInstansi;
	}

	public void setAlamatInstansi(String alamatInstansi) {
		this.alamatInstansi = alamatInstansi;
	}

	public String getKabupaten() {
		return kabupaten;
	}

	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}

	public String getTahunAktif() {
		return tahunAktif;
	}

	public void setTahunAktif(String tahunAktif) {
		this.tahunAktif = tahunAktif;
	}
	
	
}
