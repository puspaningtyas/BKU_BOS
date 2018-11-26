package com.project.bku.service.impl;

import com.project.bku.exception.BadRequestException;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.ManajemenSekolah;
import com.project.bku.model.Sekolah;
import com.project.bku.payload.ManajemenSekolahDto;
import com.project.bku.repository.ManajemenSekolahRepository;
import com.project.bku.repository.SekolahRepository;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.ManajemenSekolahService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManajemenSekolahServiceImpl implements ManajemenSekolahService {

    @Autowired
    ManajemenSekolahRepository manajemenSekolahRepository;

    @Autowired
    SekolahRepository sekolahRepository;

    @Autowired
    ModelMapper modelMapper;

    public Sekolah save(UserPrincipal currentUser, ManajemenSekolahDto manajemenSekolahDto){

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        Sekolah sekolah = sekolahRepository.findById(npsn)
                .orElseThrow(() -> new ResourceNotFoundException("Sekolah", "id", npsn));
        ManajemenSekolah result = modelMapper.map(manajemenSekolahDto, ManajemenSekolah.class);

        /**
         * Jika belum ada.
         */
        if (sekolah.getManagementSekolah() == null) {
            sekolah.setManagementSekolah(result);
            return sekolahRepository.save(sekolah);
            /**
             * Jika sudah ada.
             */
        }else {
            result.setId(sekolah.getManagementSekolah().getId());
            manajemenSekolahRepository.save(result);
            return sekolah;
        }
    }
}
