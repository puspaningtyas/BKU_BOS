package com.project.bku.service;

import java.util.List;

import com.project.bku.payload.BkuDto;
import com.project.bku.security.UserPrincipal;

public interface BkuService{
	public BkuDto getById(UserPrincipal currentUser, Long id);
	
	public List<BkuDto> getAllBku(UserPrincipal currentUser);
	
	public BkuDto save(UserPrincipal currentUser, BkuDto bkuDto);
	
	public BkuDto update(UserPrincipal currentUser, BkuDto bkuDto);
	
	public void delete(UserPrincipal currentUser, Long id);
}
