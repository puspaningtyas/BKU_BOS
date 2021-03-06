package com.project.bku.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.bku.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String username;

	private String tahunAktif;

	private Long npsn;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal() {
		super();
	}

	public UserPrincipal(Long id, String name, String username, String tahunAktif, String email, String password,
			Collection<? extends GrantedAuthority> authorities, Long npsn) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.tahunAktif = tahunAktif;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.npsn = npsn;
	}

	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
		Long npsn = null;
		if (user.getSekolah() != null) {
			npsn = user.getSekolah().getNpsn();
		};
		return new UserPrincipal(user.getId(), user.getName(), user.getUsername(), user.getTahunAktif(), user.getEmail(), user.getPassword(),
				authorities, npsn);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTahunAktif() {
		return tahunAktif;
	}

	public Long getNpsn() {
		return npsn;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}