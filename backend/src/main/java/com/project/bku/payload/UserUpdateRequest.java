package com.project.bku.payload;

import javax.validation.constraints.*;

public class UserUpdateRequest {
	
	@NotNull(message="Please Enter Id")
    private Long id;
	
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @NotBlank
    @Size(max=100)
    private String instansi;
    
    @NotBlank
    @Size(max=200)
    private String alamatInstansi;
    
    @NotBlank
    @Size(max=50)
    private String kabupaten;
    
    @NotBlank
    @Size(min=4, max=4)
    private String tahunAktif;

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