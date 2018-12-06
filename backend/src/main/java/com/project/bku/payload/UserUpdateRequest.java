package com.project.bku.payload;

import javax.validation.constraints.*;

public class UserUpdateRequest {

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

	public String getTahunAktif() {
		return tahunAktif;
	}

	public void setTahunAktif(String tahunAktif) {
		this.tahunAktif = tahunAktif;
	}
    
}