package com.project.bku.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.project.bku.exception.BadRequestException;
import com.project.bku.payload.SekolahDtoSimple;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.model.Sekolah;
import com.project.bku.payload.SekolahDto;
import com.project.bku.repository.SekolahRepository;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.SekolahService;

@RestController
@RequestMapping("/api/sekolah")
public class SekolahController {

    @Autowired
    SekolahRepository sekolahRepository;

    @Autowired
    SekolahService sekolahServiceImpl;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/search")
    public List<SekolahDtoSimple> getList() {
        List<Sekolah> list = sekolahRepository.findAll();
        return list.stream().map(lis -> modelMapper.map(lis, SekolahDtoSimple.class)).collect(Collectors.toList());
    }

    @GetMapping("/search/{npsn}")
    public SekolahDtoSimple getSekolaByNpsn(@PathVariable(value = "npsn") String npsn) {
        Long npsnn = null;
        try {
            npsnn = Long.valueOf(npsn);
        } catch (NumberFormatException a) {
            throw new BadRequestException("Format Salah");
        }
        return modelMapper.map(sekolahServiceImpl.getSekolah(npsnn), SekolahDtoSimple.class);
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('BENDAHARA', 'PEMERIKSA')")
    public Sekolah getCurrentSekolah(@CurrentUser UserPrincipal currentUser) {
        return sekolahServiceImpl.getCurrentSekolah(currentUser);
    }

    @PostMapping("/save/{npsn}")
    @PreAuthorize("hasAnyRole('BENDAHARA', 'PEMERIKSA')")
    public Sekolah save(@CurrentUser UserPrincipal currentUser, @PathVariable(value = "npsn") String npsn) {
        Long npsnn = null;
        try {
            npsnn = Long.valueOf(npsn);
        } catch (NumberFormatException a) {
            throw new BadRequestException("Format Salah");
        }
        return sekolahServiceImpl.findAndSetSekolah(currentUser, npsnn);
    }

    @PostMapping("save")
    @PreAuthorize("hasRole('BENDAHARA')")
    public Sekolah save(@CurrentUser UserPrincipal currentUser, @RequestBody SekolahDto sekolahDto) {
        return sekolahServiceImpl.createAndSetSekolah(currentUser, sekolahDto);
    }

    @PutMapping
    @PreAuthorize("hasRole('BENDAHARA')")
    public Sekolah update(@CurrentUser UserPrincipal currentUser, @RequestBody SekolahDto sekolahDto) {
        return sekolahServiceImpl.update(currentUser, sekolahDto);
    }
}