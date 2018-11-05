package com.project.bku.service;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.security.UserPrincipal;

public interface SekolahService {
	
	public Sekolah getSekolah(UserPrincipal currentUser, Long npsn);
	
	public Sekolah save(UserPrincipal currentUser, SekolahDto sekolah);
	
	public Sekolah update(UserPrincipal currentUser, SekolahDto param);
}
