package com.project.bku.payload;

import javax.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
    @NotBlank
    @Size(min=4, max=4)
    private String tahunAktif;

    private String sekolah_id;
    
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getTahunAktif() {
		return tahunAktif;
	}

	public void setTahunAktif(String tahunAktif) {
		this.tahunAktif = tahunAktif;
	}

	public String getSekolah_id() {
		return sekolah_id;
	}

	public void setSekolah_id(String sekolah_id) {
		this.sekolah_id = sekolah_id;
	}
}