package com.project.bku.service.impl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.bku.excelreader.BKUConverter;
import com.project.bku.payload.BkuExcelReponse;
import com.project.bku.payload.DownloadFileResponse;
import com.project.bku.payload.PagedResponse;
import com.project.bku.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.bku.converter.Bku2018Converter;
import com.project.bku.exception.*;
import com.project.bku.model.*;
import com.project.bku.payload.BkuDto;
import com.project.bku.repository.*;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.BkuService;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BkuServiceImpl implements BkuService {

    @Autowired
    RepositoryBku2018 repositoryBku2018;

    @Autowired
    RepositoryBku2019 repositoryBku2019;

    @Autowired
    RepositoryBku2020 repositoryBku2020;

    @Autowired
    RepositoryBku2021 repositoryBku2021;

    @Autowired
    RepositoryBku2022 repositoryBku2022;

    @Autowired
    RepositoryBku2023 repositoryBku2023;

    @Autowired
    RepositoryBku2024 repositoryBku2024;

    @Autowired
    RepositoryBku2025 repositoryBku2025;

    @Autowired
    RepositoryBku2026 repositoryBku2026;

    @Autowired
    RepositoryBku2027 repositoryBku2027;

    @Autowired
    RepositoryBku2028 repositoryBku2028;

    @Autowired
    SekolahRepository sekolahRepository;

    @Autowired
    Bku2018Converter bku2018ConverterImpl;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BKUConverter bkuConverter;

    @Override
    public BkuDto getById(UserPrincipal currentUser, Long id) {
        String tahunTabel = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        BkuDto bku = null;

        if (tahunTabel.equals("2018")) {
            Bku2018 bku2018 = repositoryBku2018.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            bku = modelMapper.map(bku2018, BkuDto.class);
        } else if (tahunTabel.equals("2019")) {
            Bku2019 bku2019 = repositoryBku2019.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));
            bku = modelMapper.map(bku2019, BkuDto.class);
        } else if (tahunTabel.equals("2020")) {
            Bku2020 bku2020 = repositoryBku2020.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));
            bku = modelMapper.map(bku2020, BkuDto.class);
        } else if (tahunTabel.equals("2021")) {
            Bku2021 bku2021 = repositoryBku2021.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));
            bku = modelMapper.map(bku2021, BkuDto.class);
        } else if (tahunTabel.equals("2022")) {
            Bku2022 bku2022 = repositoryBku2022.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));
            bku = modelMapper.map(bku2022, BkuDto.class);
        } else if (tahunTabel.equals("2023")) {
            Bku2023 bku2023 = repositoryBku2023.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));
            bku = modelMapper.map(bku2023, BkuDto.class);
        } else if (tahunTabel.equals("2024")) {
            Bku2024 bku2024 = repositoryBku2024.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));
            bku = modelMapper.map(bku2024, BkuDto.class);
        } else if (tahunTabel.equals("2025")) {
            Bku2025 bku2025 = repositoryBku2025.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));
            bku = modelMapper.map(bku2025, BkuDto.class);
        } else if (tahunTabel.equals("2026")) {
            Bku2026 bku2026 = repositoryBku2026.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));
            bku = modelMapper.map(bku2026, BkuDto.class);
        } else if (tahunTabel.equals("2027")) {
            Bku2027 bku2027 = repositoryBku2027.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));
            bku = modelMapper.map(bku2027, BkuDto.class);
        } else if (tahunTabel.equals("2028")) {
            Bku2028 bku2028 = repositoryBku2028.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));
            bku = modelMapper.map(bku2028, BkuDto.class);
        } else {
            throw new BadRequestException("Resource not found.");
        }
        return bku;
    }

    @Override
    public PagedResponse<BkuDto> getAllBku(UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        //cek tahunTabel aktif
        String tahunTabel = currentUser.getTahunAktif();

        //cek npsn
        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        //create pageable
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        //temp
        PagedResponse<BkuDto> pagedResponse = null;

        if (tahunTabel.equals("2018")) {
            Page<Bku2018> bku = repositoryBku2018.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2019")) {
            Page<Bku2019> bku = repositoryBku2019.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2020")) {
            Page<Bku2020> bku = repositoryBku2020.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2021")) {
            Page<Bku2021> bku = repositoryBku2021.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2022")) {
            Page<Bku2022> bku = repositoryBku2022.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2023")) {
            Page<Bku2023> bku = repositoryBku2023.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2024")) {
            Page<Bku2024> bku = repositoryBku2024.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2025")) {
            Page<Bku2025> bku = repositoryBku2025.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2026")) {
            Page<Bku2026> bku = repositoryBku2026.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2027")) {
            Page<Bku2027> bku = repositoryBku2027.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else if (tahunTabel.equals("2028")) {
            Page<Bku2028> bku = repositoryBku2028.findAllBySekolahNpsn(npsn, pageable);
            List<BkuDto> bkuDtos = bku.getContent().stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
            pagedResponse = new PagedResponse<>(bkuDtos, bku.getNumber(), bku.getSize(), bku.getTotalElements(),
                    bku.getTotalPages(), bku.isLast());
        } else {
            throw new BadRequestException("Resource not found.");
        }
        return pagedResponse;
    }

    private void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

    // not used
    @Override
    public List<BkuDto> getAllBku(UserPrincipal currentUser) {
        String tahunTabel = currentUser.getTahunAktif();
        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }
        List<BkuDto> bku = null;
        if (tahunTabel.equals("2018")) {
            List<Bku2018> list = repositoryBku2018.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2019")) {
            List<Bku2019> list = repositoryBku2019.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2020")) {
            List<Bku2020> list = repositoryBku2020.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2021")) {
            List<Bku2021> list = repositoryBku2021.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2022")) {
            List<Bku2022> list = repositoryBku2022.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2023")) {
            List<Bku2023> list = repositoryBku2023.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2024")) {
            List<Bku2024> list = repositoryBku2024.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2025")) {
            List<Bku2025> list = repositoryBku2025.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2026")) {
            List<Bku2026> list = repositoryBku2026.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2027")) {
            List<Bku2027> list = repositoryBku2027.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahunTabel.equals("2028")) {
            List<Bku2028> list = repositoryBku2028.findAllByNpsn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else {
            throw new BadRequestException("Resource not found.");
        }
        return bku;
    }

    @Override
    public BkuDto save(UserPrincipal currentUser, BkuDto bkuDto) {
        // berdasarkan user aktif
        String tahunTabel = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        // cek npsn user aktiv

        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }
        // get sekolah untuk direferensikan ke new BKU
        Sekolah sekolah = sekolahRepository.findById(npsn)
                .orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", bkuDto.getId()));

        BkuDto dto = null;
        if (tahunTabel.equals("2018")) {
            Bku2018 bku = modelMapper.map(bkuDto, Bku2018.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2018.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2019")) {
            Bku2019 bku = modelMapper.map(bkuDto, Bku2019.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2019.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2020")) {
            Bku2020 bku = modelMapper.map(bkuDto, Bku2020.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2020.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2021")) {
            Bku2021 bku = modelMapper.map(bkuDto, Bku2021.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2021.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2022")) {
            Bku2022 bku = modelMapper.map(bkuDto, Bku2022.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2022.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2023")) {
            Bku2023 bku = modelMapper.map(bkuDto, Bku2023.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2023.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2024")) {
            Bku2024 bku = modelMapper.map(bkuDto, Bku2024.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2024.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2025")) {
            Bku2025 bku = modelMapper.map(bkuDto, Bku2025.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2025.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2026")) {
            Bku2026 bku = modelMapper.map(bkuDto, Bku2026.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2026.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2027")) {
            Bku2027 bku = modelMapper.map(bkuDto, Bku2027.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2027.save(bku), BkuDto.class);
        } else if (tahunTabel.equals("2028")) {
            Bku2028 bku = modelMapper.map(bkuDto, Bku2028.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2028.save(bku), BkuDto.class);
        }
        return dto;
    }

    public BkuDto update(UserPrincipal currentUser, BkuDto bkuDto) {
        String tahunTabel = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        BkuDto dto = null;
        if (bkuDto.getId() == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }
        if (tahunTabel.equals("2018")) {
            repositoryBku2018.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2018.save(modelMapper.map(bkuDto, Bku2018.class)), BkuDto.class);
        } else if (tahunTabel.equals("2019")) {
            repositoryBku2019.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2019.save(modelMapper.map(bkuDto, Bku2019.class)), BkuDto.class);
        } else if (tahunTabel.equals("2020")) {
            repositoryBku2020.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2020.save(modelMapper.map(bkuDto, Bku2020.class)), BkuDto.class);
        } else if (tahunTabel.equals("2021")) {
            repositoryBku2021.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2021.save(modelMapper.map(bkuDto, Bku2021.class)), BkuDto.class);
        } else if (tahunTabel.equals("2022")) {
            repositoryBku2022.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2022.save(modelMapper.map(bkuDto, Bku2022.class)), BkuDto.class);
        } else if (tahunTabel.equals("2023")) {
            repositoryBku2023.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2023.save(modelMapper.map(bkuDto, Bku2023.class)), BkuDto.class);
        } else if (tahunTabel.equals("2024")) {
            repositoryBku2024.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2024.save(modelMapper.map(bkuDto, Bku2024.class)), BkuDto.class);
        } else if (tahunTabel.equals("2025")) {
            repositoryBku2025.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2025.save(modelMapper.map(bkuDto, Bku2025.class)), BkuDto.class);
        } else if (tahunTabel.equals("2026")) {
            repositoryBku2026.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2026.save(modelMapper.map(bkuDto, Bku2026.class)), BkuDto.class);
        } else if (tahunTabel.equals("2027")) {
            repositoryBku2027.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2027.save(modelMapper.map(bkuDto, Bku2027.class)), BkuDto.class);
        } else if (tahunTabel.equals("2028")) {
            repositoryBku2028.findByIdNpsn(bkuDto.getId(), npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2028.save(modelMapper.map(bkuDto, Bku2028.class)), BkuDto.class);
        } else {
            throw new BadRequestException("Resource not found.");
        }

        return dto;
    }


    @Override
    public void delete(UserPrincipal currentUser, Long id) {
        String tahunTabel = currentUser.getTahunAktif();
        if (id == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        if (tahunTabel.equals("2018")) {
            Bku2018 bku2018 = repositoryBku2018.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            repositoryBku2018.delete(bku2018);
        } else if (tahunTabel.equals("2019")) {
            Bku2019 bku2019 = repositoryBku2019.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));
            repositoryBku2019.delete(bku2019);
        } else if (tahunTabel.equals("2020")) {
            Bku2020 bku2020 = repositoryBku2020.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));
            repositoryBku2020.delete(bku2020);
        } else if (tahunTabel.equals("2021")) {
            Bku2021 bku2021 = repositoryBku2021.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));
            repositoryBku2021.delete(bku2021);
        } else if (tahunTabel.equals("2022")) {
            Bku2022 bku2022 = repositoryBku2022.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));
            repositoryBku2022.delete(bku2022);
        } else if (tahunTabel.equals("2023")) {
            Bku2023 bku2023 = repositoryBku2023.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));
            repositoryBku2023.delete(bku2023);
        } else if (tahunTabel.equals("2024")) {
            Bku2024 bku2024 = repositoryBku2024.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));
            repositoryBku2024.delete(bku2024);
        } else if (tahunTabel.equals("2025")) {
            Bku2025 bku2025 = repositoryBku2025.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));
            repositoryBku2025.delete(bku2025);
        } else if (tahunTabel.equals("2026")) {
            Bku2026 bku2026 = repositoryBku2026.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));
            repositoryBku2026.delete(bku2026);
        } else if (tahunTabel.equals("2027")) {
            Bku2027 bku2027 = repositoryBku2027.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));
            repositoryBku2027.delete(bku2027);
        } else if (tahunTabel.equals("2028")) {
            Bku2028 bku2028 = repositoryBku2028.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));
            repositoryBku2028.delete(bku2028);
        } else {
            throw new BadRequestException("Resource not found.");
        }
    }

    @Override
    public BkuDto uploadFile(UserPrincipal currentUser, Long id, MultipartFile file) {
        String tahunTabel = currentUser.getTahunAktif();
        BkuDto dto = null;
        if (id == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }

        //ambil nama asli
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }
        try {
            if (tahunTabel.equals("2018")) {
                Bku2018 bku = repositoryBku2018.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2018.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2019")) {
                Bku2019 bku = repositoryBku2019.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2019.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2020")) {
                Bku2020 bku = repositoryBku2020.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2020.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2021")) {
                Bku2021 bku = repositoryBku2021.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2021.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2022")) {
                Bku2022 bku = repositoryBku2022.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2022.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2023")) {
                Bku2023 bku = repositoryBku2023.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2023.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2024")) {
                Bku2024 bku = repositoryBku2024.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2024.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2025")) {
                Bku2025 bku = repositoryBku2025.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2025.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2026")) {
                Bku2026 bku = repositoryBku2026.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2026.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2027")) {
                Bku2027 bku = repositoryBku2027.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2027.save(bku), BkuDto.class);
            } else if (tahunTabel.equals("2028")) {
                Bku2028 bku = repositoryBku2028.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));

                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2028.save(bku), BkuDto.class);
            } else {
                throw new BadRequestException("Resource not found.");
            }
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return dto;
    }

    @Override
    public DownloadFileResponse downloadFile(UserPrincipal currentUser, Long id) {
        String tahunTabel = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        DownloadFileResponse downloadFileResponse = null;

        if (tahunTabel.equals("2018")) {
            Bku2018 bku = repositoryBku2018.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2019")) {
            Bku2019 bku = repositoryBku2019.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2020")) {
            Bku2020 bku = repositoryBku2020.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2021")) {
            Bku2021 bku = repositoryBku2021.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2022")) {
            Bku2022 bku = repositoryBku2022.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2023")) {
            Bku2023 bku = repositoryBku2023.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2024")) {
            Bku2024 bku = repositoryBku2024.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2025")) {
            Bku2025 bku = repositoryBku2025.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2026")) {
            Bku2026 bku = repositoryBku2026.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2027")) {
            Bku2027 bku = repositoryBku2027.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else if (tahunTabel.equals("2028")) {
            Bku2028 bku = repositoryBku2028.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));
            if(bku.getFileName() == null){
                throw new BadRequestException("File tidak ditemukan");
            }
            downloadFileResponse = modelMapper.map(bku, DownloadFileResponse.class);
        } else {
            throw new BadRequestException("Resource not found.");
        }
        return downloadFileResponse;
    }

    @Override
    public List<BkuExcelReponse> saveExcel(UserPrincipal currentUser, MultipartFile file) throws IllegalStateException, IOException {
        byte[] fileBytes = file.getBytes();
        //save temp file
        File temp = File.createTempFile("temp-file-name", ".tmp");
        FileOutputStream fos = new FileOutputStream(temp);
        fos.write(fileBytes);
        temp.deleteOnExit();

        //getTahunAktif
        String tahunTabel = currentUser.getTahunAktif();

        //cek npsn
        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        //getListFrom excel
        List<BkuDto> listBku = bkuConverter.readExcel(temp);

        //cek tahun
        verification(listBku, tahunTabel, npsn);

        //getSekolah
        Sekolah sekolah = sekolahRepository.findById(npsn)
                .orElseThrow(() -> new ResourceNotFoundException("Sekolah", "id", npsn));

        // get range days in month
        Date start = getFirstDateOfMonth(listBku.get(1).getTanggal());
        Date end = getLastDateOfMonth(listBku.get(1).getTanggal());

        if (tahunTabel.equals("2018")) {
            List<Bku2018> list = repositoryBku2018.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            List<Bku2018> list2 = repositoryBku2018.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2018.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
                repositoryBku2018.deleteByUraian(listBku.get(0).getUraian());
            }

            for (BkuDto bkuDto : listBku) {
                Bku2018 bku = modelMapper.map(bkuDto, Bku2018.class);
                bku.setSekolah(sekolah);
                repositoryBku2018.save(bku);
            }
        } else if (tahunTabel.equals("2019")) {
            List<Bku2019> list = repositoryBku2019.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2019.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2019 bku = modelMapper.map(bkuDto, Bku2019.class);
                bku.setSekolah(sekolah);
                repositoryBku2019.save(bku);
            }
        } else if (tahunTabel.equals("2019")) {
            List<Bku2019> list = repositoryBku2019.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2019.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2019 bku = modelMapper.map(bkuDto, Bku2019.class);
                bku.setSekolah(sekolah);
                repositoryBku2019.save(bku);
            }
        } else if (tahunTabel.equals("2020")) {
            List<Bku2020> list = repositoryBku2020.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2020.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2020 bku = modelMapper.map(bkuDto, Bku2020.class);
                bku.setSekolah(sekolah);
                repositoryBku2020.save(bku);
            }
        } else if (tahunTabel.equals("2021")) {
            List<Bku2021> list = repositoryBku2021.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2021.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2021 bku = modelMapper.map(bkuDto, Bku2021.class);
                bku.setSekolah(sekolah);
                repositoryBku2021.save(bku);
            }
        } else if (tahunTabel.equals("2022")) {
            List<Bku2022> list = repositoryBku2022.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2022.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2022 bku = modelMapper.map(bkuDto, Bku2022.class);
                bku.setSekolah(sekolah);
                repositoryBku2022.save(bku);
            }
        } else if (tahunTabel.equals("2023")) {
            List<Bku2023> list = repositoryBku2023.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2023.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2023 bku = modelMapper.map(bkuDto, Bku2023.class);
                bku.setSekolah(sekolah);
                repositoryBku2023.save(bku);
            }
        } else if (tahunTabel.equals("2024")) {
            List<Bku2024> list = repositoryBku2024.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2024.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2024 bku = modelMapper.map(bkuDto, Bku2024.class);
                bku.setSekolah(sekolah);
                repositoryBku2024.save(bku);
            }
        } else if (tahunTabel.equals("2025")) {
            List<Bku2025> list = repositoryBku2025.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2025.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2025 bku = modelMapper.map(bkuDto, Bku2025.class);
                bku.setSekolah(sekolah);
                repositoryBku2025.save(bku);
            }
        } else if (tahunTabel.equals("2026")) {
            List<Bku2026> list = repositoryBku2026.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2026.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2026 bku = modelMapper.map(bkuDto, Bku2026.class);
                bku.setSekolah(sekolah);
                repositoryBku2026.save(bku);
            }
        } else if (tahunTabel.equals("2027")) {
            List<Bku2027> list = repositoryBku2027.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2027.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2027 bku = modelMapper.map(bkuDto, Bku2027.class);
                bku.setSekolah(sekolah);
                repositoryBku2027.save(bku);
            }
        } else if (tahunTabel.equals("2028")) {
            List<Bku2028> list = repositoryBku2028.findAllBySekolahNpsnAndTanggalBetween(npsn, start, end);
            if (list.size() > 0) {
                repositoryBku2028.deleteBySekolahNpsnAndTanggalBetween(npsn, start, end);
            }

            for (BkuDto bkuDto : listBku) {
                Bku2028 bku = modelMapper.map(bkuDto, Bku2028.class);
                bku.setSekolah(sekolah);
                repositoryBku2028.save(bku);
            }
        }else{
            throw new BadRequestException("Resource tidak ditemukan");
        }
        List<BkuExcelReponse> er = listBku.stream().map(lis -> modelMapper.map(lis, BkuExcelReponse.class)).collect(Collectors.toList());
        return er;
    }

    public void verification(List<BkuDto> listBku, String tahunTabel, Long npsn) {

        //cek file
        if (listBku.size() == 0) {
            throw new BadRequestException("File Kosong, ikuti standar penulisan BKU");
            //cek npsn
        } else if (!listBku.get(0).getNpsn().equals(npsn)) {
            throw new BadRequestException("NPSN anda tidak sesuai dengan NPSN di file excel");
        }

        for (int i = 0; i < listBku.size(); i++) {
            //cek bulan
            if (i < (listBku.size() - 1) && i != 0) {
                if (!getMonth(listBku.get(i).getTanggal()).equals(getMonth(listBku.get(i + 1).getTanggal()))) {
                    throw new BadRequestException("Bulan pada uraian '" + listBku.get(i).getUraian() + "' tidak sama dengan '" + listBku.get(i + 1).getUraian() + "'");
                }
            }
            //cek tahun
            if (!tahunTabel.equals(getYear(listBku.get(i).getTanggal()))) {
                throw new BadRequestException("Tahun aktif dan tahun kegiatan pada " + listBku.get(i).getUraian() + " tidak sesuai");
            }
        }
    }

    public String getYear(Date date) {
        Date d = date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        return df.format(d);
    }

    public String getMonth(Date date) {
        Date d = date;
        SimpleDateFormat df = new SimpleDateFormat("MM");
        return df.format(d);
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
}

