package com.project.bku.service;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.security.UserPrincipal;

public interface SekolahService {

	public Sekolah getSekolah(Long npsn);

	public Sekolah getCurrentSekolah(UserPrincipal currentUser);

	//mencari npsn sekolah dan set ke user
	public Sekolah findAndSetSekolah(UserPrincipal currentUser, Long npsn);

	//membuat sekolah baru dan set ke user
	public Sekolah createAndSetSekolah(UserPrincipal currentUser, SekolahDto sekolah);

	public Sekolah update(UserPrincipal currentUser, SekolahDto param);
}
