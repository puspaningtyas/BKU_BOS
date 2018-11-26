package com.project.bku.service;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.ManajemenSekolahDto;
import com.project.bku.security.UserPrincipal;

public interface ManajemenSekolahService {

    public Sekolah save(UserPrincipal currentUser, ManajemenSekolahDto param);

}
