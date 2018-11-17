package com.project.bku.service.impl;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import com.project.bku.excelreader.Bku;
import com.project.bku.excelreader.BkuConverter;
import com.project.bku.payload.DownloadFileResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.apache.commons.fileupload.disk.DiskFileItem;

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
    BkuConverter bkuConverter;

    @Override
    public BkuDto getById(UserPrincipal currentUser, Long id) {
        String tahun = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        BkuDto bku = null;

        if (tahun.equals("2018")) {
            Bku2018 bku2018 = repositoryBku2018.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            bku = modelMapper.map(bku2018, BkuDto.class);
        } else if (tahun.equals("2019")) {
            Bku2019 bku2019 = repositoryBku2019.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));
            bku = modelMapper.map(bku2019, BkuDto.class);
        } else if (tahun.equals("2020")) {
            Bku2020 bku2020 = repositoryBku2020.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));
            bku = modelMapper.map(bku2020, BkuDto.class);
        } else if (tahun.equals("2021")) {
            Bku2021 bku2021 = repositoryBku2021.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));
            bku = modelMapper.map(bku2021, BkuDto.class);
        } else if (tahun.equals("2022")) {
            Bku2022 bku2022 = repositoryBku2022.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));
            bku = modelMapper.map(bku2022, BkuDto.class);
        } else if (tahun.equals("2023")) {
            Bku2023 bku2023 = repositoryBku2023.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));
            bku = modelMapper.map(bku2023, BkuDto.class);
        } else if (tahun.equals("2024")) {
            Bku2024 bku2024 = repositoryBku2024.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));
            bku = modelMapper.map(bku2024, BkuDto.class);
        } else if (tahun.equals("2025")) {
            Bku2025 bku2025 = repositoryBku2025.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));
            bku = modelMapper.map(bku2025, BkuDto.class);
        } else if (tahun.equals("2026")) {
            Bku2026 bku2026 = repositoryBku2026.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));
            bku = modelMapper.map(bku2026, BkuDto.class);
        } else if (tahun.equals("2027")) {
            Bku2027 bku2027 = repositoryBku2027.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));
            bku = modelMapper.map(bku2027, BkuDto.class);
        } else if (tahun.equals("2028")) {
            Bku2028 bku2028 = repositoryBku2028.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));
            bku = modelMapper.map(bku2028, BkuDto.class);
        } else {
            throw new BadRequestException("Resource tidak ditemukan");
        }
        return bku;
    }

    @Override
    public List<BkuDto> getAllBku(UserPrincipal currentUser) {
        String tahun = currentUser.getTahunAktif();
        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }
        List<BkuDto> bku = null;
        if (tahun.equals("2018")) {
            List<Bku2018> list = repositoryBku2018.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2019")) {
            List<Bku2019> list = repositoryBku2019.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2020")) {
            List<Bku2020> list = repositoryBku2020.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2021")) {
            List<Bku2021> list = repositoryBku2021.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2022")) {
            List<Bku2022> list = repositoryBku2022.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2023")) {
            List<Bku2023> list = repositoryBku2023.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2024")) {
            List<Bku2024> list = repositoryBku2024.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2025")) {
            List<Bku2025> list = repositoryBku2025.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2026")) {
            List<Bku2026> list = repositoryBku2026.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2027")) {
            List<Bku2027> list = repositoryBku2027.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else if (tahun.equals("2028")) {
            List<Bku2028> list = repositoryBku2028.findAllByNisn(npsn);
            bku = list.stream().map(lis -> modelMapper.map(lis, BkuDto.class)).collect(Collectors.toList());
        } else {
            throw new BadRequestException("Resource tidak ditemukan");
        }
        return bku;
    }

    @Override
    public BkuDto save(UserPrincipal currentUser, BkuDto bkuDto) {
        // berdasarkan user aktif
        String tahun = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        // cek npsn user aktiv

        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }
        // get sekolah untuk direferensikan ke new BKU
        Sekolah sekolah = sekolahRepository.findById(npsn)
                .orElseThrow(() -> new ResourceNotFoundException("Sekolah", "NPSN", bkuDto.getId()));

        BkuDto dto = null;
        if (tahun.equals("2018")) {
            Bku2018 bku = modelMapper.map(bkuDto, Bku2018.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2018.save(bku), BkuDto.class);
        } else if (tahun.equals("2019")) {
            Bku2019 bku = modelMapper.map(bkuDto, Bku2019.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2019.save(bku), BkuDto.class);
        } else if (tahun.equals("2020")) {
            Bku2020 bku = modelMapper.map(bkuDto, Bku2020.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2020.save(bku), BkuDto.class);
        } else if (tahun.equals("2021")) {
            Bku2021 bku = modelMapper.map(bkuDto, Bku2021.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2021.save(bku), BkuDto.class);
        } else if (tahun.equals("2022")) {
            Bku2022 bku = modelMapper.map(bkuDto, Bku2022.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2022.save(bku), BkuDto.class);
        } else if (tahun.equals("2023")) {
            Bku2023 bku = modelMapper.map(bkuDto, Bku2023.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2023.save(bku), BkuDto.class);
        } else if (tahun.equals("2024")) {
            Bku2024 bku = modelMapper.map(bkuDto, Bku2024.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2024.save(bku), BkuDto.class);
        } else if (tahun.equals("2025")) {
            Bku2025 bku = modelMapper.map(bkuDto, Bku2025.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2025.save(bku), BkuDto.class);
        } else if (tahun.equals("2026")) {
            Bku2026 bku = modelMapper.map(bkuDto, Bku2026.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2026.save(bku), BkuDto.class);
        } else if (tahun.equals("2027")) {
            Bku2027 bku = modelMapper.map(bkuDto, Bku2027.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2027.save(bku), BkuDto.class);
        } else if (tahun.equals("2028")) {
            Bku2028 bku = modelMapper.map(bkuDto, Bku2028.class);
            bku.setSekolah(sekolah);
            dto = modelMapper.map(repositoryBku2028.save(bku), BkuDto.class);
        }
        return dto;
    }

    public BkuDto update(UserPrincipal currentUser, BkuDto bkuDto) {
        String tahun = currentUser.getTahunAktif();
        BkuDto dto = null;
        if (bkuDto.getId() == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }
        if (tahun.equals("2018")) {
            repositoryBku2018.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2018.save(modelMapper.map(bkuDto, Bku2018.class)), BkuDto.class);
        } else if (tahun.equals("2019")) {
            repositoryBku2019.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2019.save(modelMapper.map(bkuDto, Bku2019.class)), BkuDto.class);
        } else if (tahun.equals("2020")) {
            repositoryBku2020.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2020.save(modelMapper.map(bkuDto, Bku2020.class)), BkuDto.class);
        } else if (tahun.equals("2021")) {
            repositoryBku2021.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2021.save(modelMapper.map(bkuDto, Bku2021.class)), BkuDto.class);
        } else if (tahun.equals("2022")) {
            repositoryBku2022.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2022.save(modelMapper.map(bkuDto, Bku2022.class)), BkuDto.class);
        } else if (tahun.equals("2023")) {
            repositoryBku2023.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2023.save(modelMapper.map(bkuDto, Bku2023.class)), BkuDto.class);
        } else if (tahun.equals("2024")) {
            repositoryBku2024.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2024.save(modelMapper.map(bkuDto, Bku2024.class)), BkuDto.class);
        } else if (tahun.equals("2025")) {
            repositoryBku2025.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2025.save(modelMapper.map(bkuDto, Bku2025.class)), BkuDto.class);
        } else if (tahun.equals("2026")) {
            repositoryBku2026.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2026.save(modelMapper.map(bkuDto, Bku2026.class)), BkuDto.class);
        } else if (tahun.equals("2027")) {
            repositoryBku2027.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2027.save(modelMapper.map(bkuDto, Bku2027.class)), BkuDto.class);
        } else if (tahun.equals("2028")) {
            repositoryBku2028.findById(bkuDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", bkuDto.getId()));
            dto = modelMapper.map(repositoryBku2028.save(modelMapper.map(bkuDto, Bku2028.class)), BkuDto.class);
        }

        return dto;
    }


    @Override
    public void delete(UserPrincipal currentUser, Long id) {
        String tahun = currentUser.getTahunAktif();
        if (id == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }
        if (tahun.equals("2018")) {
            Bku2018 bku2018 = repositoryBku2018.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            repositoryBku2018.delete(bku2018);
        } else if (tahun.equals("2019")) {
            Bku2019 bku2019 = repositoryBku2019.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2019", "id", id));
            repositoryBku2019.delete(bku2019);
        } else if (tahun.equals("2020")) {
            Bku2020 bku2020 = repositoryBku2020.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2020", "id", id));
            repositoryBku2020.delete(bku2020);
        } else if (tahun.equals("2021")) {
            Bku2021 bku2021 = repositoryBku2021.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2021", "id", id));
            repositoryBku2021.delete(bku2021);
        } else if (tahun.equals("2022")) {
            Bku2022 bku2022 = repositoryBku2022.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2022", "id", id));
            repositoryBku2022.delete(bku2022);
        } else if (tahun.equals("2023")) {
            Bku2023 bku2023 = repositoryBku2023.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2023", "id", id));
            repositoryBku2023.delete(bku2023);
        } else if (tahun.equals("2024")) {
            Bku2024 bku2024 = repositoryBku2024.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2024", "id", id));
            repositoryBku2024.delete(bku2024);
        } else if (tahun.equals("2025")) {
            Bku2025 bku2025 = repositoryBku2025.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2025", "id", id));
            repositoryBku2025.delete(bku2025);
        } else if (tahun.equals("2026")) {
            Bku2026 bku2026 = repositoryBku2026.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2026", "id", id));
            repositoryBku2026.delete(bku2026);
        } else if (tahun.equals("2027")) {
            Bku2027 bku2027 = repositoryBku2027.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2027", "id", id));
            repositoryBku2027.delete(bku2027);
        } else if (tahun.equals("2028")) {
            Bku2028 bku2028 = repositoryBku2028.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2028", "id", id));
            repositoryBku2028.delete(bku2028);
        } else {
            throw new BadRequestException("Resource tidak ditemukan");
        }
    }

    @Override
    public BkuDto uploadFile(UserPrincipal currentUser, Long id, MultipartFile file) {
        String tahun = currentUser.getTahunAktif();
        BkuDto dto = null;
        if (id == null) {
            throw new BadRequestException("Id tidak boleh kosong");
        }

        //ambil nama asli
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }

        if (tahun.equals("2018")) {
            Bku2018 bku = repositoryBku2018.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            try {
                bku.setFileName(fileName);
                bku.setFileType(file.getContentType());
                bku.setData(file.getBytes());
                dto = modelMapper.map(repositoryBku2018.save(bku), BkuDto.class);
            } catch (IOException ex) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            }
        }
        return dto;
    }

    @Override
    public DownloadFileResponse downloadFile(UserPrincipal currentUser, Long id) {
        String tahun = currentUser.getTahunAktif();

        Long npsn = currentUser.getNpsn();
        if (npsn == null) {
            throw new BadRequestException("Silahkan tambahkan sekolah anda.");
        }

        DownloadFileResponse bku = null;

        if (tahun.equals("2018")) {
            Bku2018 bku2018 = repositoryBku2018.findByIdNpsn(id, npsn)
                    .orElseThrow(() -> new ResourceNotFoundException("Bku2018", "id", id));
            bku = modelMapper.map(bku2018, DownloadFileResponse.class);
        } else {
            throw new BadRequestException("File tidak ditemukan");
        }
        return bku;
    }

    @Override
    public List<Bku> saveExcel(UserPrincipal currentUser, MultipartFile file) throws IllegalStateException, IOException {
        byte[] fileBytes = file.getBytes();
        File temp = File.createTempFile("temp-file-name", ".tmp");
        FileOutputStream fos = new FileOutputStream(temp);
        fos.write(fileBytes);
        temp.deleteOnExit();

        List<Bku> bku = bkuConverter.readExcel(temp);
        return bku;
    }
}
