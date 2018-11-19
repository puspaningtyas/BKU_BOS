package com.project.bku.controller;

import com.project.bku.model.Bku2018;
import com.project.bku.payload.BkuDto;
import com.project.bku.payload.PagedResponse;
import com.project.bku.repository.SekolahRepository;
import com.project.bku.service.BkuService;
import com.project.bku.utils.AppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.project.bku.repository.RepositoryBku2018;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@Autowired
	RepositoryBku2018 repositoryBku2018;

	@Autowired
    SekolahRepository sekolahRepository;

	@Autowired
	ModelMapper modelMapper;

    @Autowired
    BkuService bkuServiceImpl;
	
	@GetMapping
	public UserPrincipal get(@CurrentUser UserPrincipal currentUser) {
		return currentUser;
	}

	@GetMapping("/lob/{id}")
	public String lob(@PathVariable(name="id") Long id){
		return null;
	}

	@GetMapping("/bku")
    public Page<Bku2018> getAllBySekolah(@CurrentUser UserPrincipal currentUser,
                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        return repositoryBku2018.findAllBySekolahNpsn(currentUser.getNpsn(), pageable);
    }

    @GetMapping("/bkuDto")
    public PagedResponse<BkuDto> getAllBySekolah2(@CurrentUser UserPrincipal currentUser,
                                                  @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                  @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return bkuServiceImpl.getAllBku(currentUser, page, size);
    }

}
