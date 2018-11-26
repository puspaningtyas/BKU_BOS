package com.project.bku.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bku.converter.SekolahConverter;
import com.project.bku.exception.BadRequestException;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.Sekolah;
import com.project.bku.model.User;
import com.project.bku.payload.SekolahDto;
import com.project.bku.repository.ManajemenSekolahRepository;
import com.project.bku.repository.SekolahRepository;
import com.project.bku.repository.UserRepository;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.SekolahService;

@Service
public class SekolahServiceImpl implements SekolahService{

	@Autowired
	SekolahRepository sekolahRepository;

	@Autowired
	ManajemenSekolahRepository managemenSekolahRepository;

	@Autowired
	SekolahConverter sekolahConverterImpl;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public Sekolah createAndSetSekolah(UserPrincipal currentUser, SekolahDto sekolahDto) {
		
		// cek apakah user sudah terdaftar
		Long npsn = currentUser.getNpsn();
		if (npsn != null) {
			throw new BadRequestException("Anda sudah terdaftar disekolah!");
		}
		
		// cek apakah npsn sudah dipakai
		Optional<Sekolah> check = sekolahRepository.findById(sekolahDto.getNpsn());
		if (check.isPresent()) {
			throw new BadRequestException("NPSN sudah terdaftar!");
		}
		
		// jika belum makan simpan sekolah
		Sekolah sekolah = modelMapper.map(sekolahDto, Sekolah.class);
		Sekolah result = sekolahRepository.save(sekolah);
		
		// set sekolah ke user
		User user = userRepository.findById(currentUser.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getId()));
		user.setSekolah(result);
		userRepository.save(user);
		return result;
	}

    @Override
    public Sekolah findAndSetSekolah(UserPrincipal currentUser, Long npsn) {

	    // cek apakah user sudah terdaftar
        if (currentUser.getNpsn() != null) {
            throw new BadRequestException("Anda sudah terdaftar disekolah!");
        }

        //cari sekolah
        Sekolah result = sekolahRepository.findById(npsn)
                .orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", npsn));

        // set sekolah ke user
        User user = userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getId()));
        user.setSekolah(result);
        userRepository.save(user);

        return result;
    }

	public Sekolah getSekolah(Long npsn){
		Sekolah sekolah = sekolahRepository.findById(npsn)
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", npsn));
		return sekolah;
	}

	@Override
	public Sekolah getCurrentSekolah(UserPrincipal currentUser) {
		Long currentNpsn = currentUser.getNpsn();
		if ( currentNpsn == null) {
			throw new BadRequestException("Anda tidak memiliki relasi ke sekolah manapun.");
		}
		Sekolah sekolah = sekolahRepository.findById(currentNpsn)
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", currentNpsn));
		return sekolah;
	}



    @Override
	public Sekolah update(UserPrincipal currentUser, SekolahDto sekolahDto) {
		Long currentNPSN = currentUser.getNpsn();
		if (currentNPSN == null) {
			throw new BadRequestException("Anda tidak memiliki relasi ke sekolah manapun");
		}
		Sekolah result = sekolahRepository.findById(currentNPSN)
				.orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", currentNPSN));
		result.setNamaSekolah(sekolahDto.getNamaSekolah());
		result.setNss(sekolahDto.getNss());
		result.setAlamat(sekolahDto.getAlamat());
		result.setRt(sekolahDto.getRt());
		result.setRw(sekolahDto.getRw());
		result.setDusun(sekolahDto.getDusun());
		result.setDesaKelurahan(sekolahDto.getDesaKelurahan());
		result.setKecamatan(sekolahDto.getKecamatan());
		result.setKabupatenKota(sekolahDto.getKabupatenKota());
		result.setProvinsi(sekolahDto.getProvinsi());
		result.setKodePos(sekolahDto.getKodePos());
		result.setNoRekening(sekolahDto.getNoRekening());
		result.setNamaBank(sekolahDto.getNamaBank());
		result.setNpwp(sekolahDto.getNpwp());
		result.setEmail(sekolahDto.getEmail());
		return sekolahRepository.save(result);
	}
}
