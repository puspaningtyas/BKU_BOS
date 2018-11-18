package com.project.bku.service;

import java.io.IOException;
import java.util.List;

import com.project.bku.payload.BkuDto;
import com.project.bku.payload.DownloadFileResponse;
import com.project.bku.payload.PagedResponse;
import com.project.bku.security.UserPrincipal;
import org.springframework.web.multipart.MultipartFile;

public interface BkuService{
	public BkuDto getById(UserPrincipal currentUser, Long id);
	
	public List<BkuDto> getAllBku(UserPrincipal currentUser);

	public PagedResponse<BkuDto> getAllBku(UserPrincipal currentUser, int page, int size);
	
	public BkuDto save(UserPrincipal currentUser, BkuDto bkuDto);

    public List<BkuDto> saveExcel(UserPrincipal currentUser, MultipartFile file) throws IOException;
	
	public BkuDto update(UserPrincipal currentUser, BkuDto bkuDto);
	
	public void delete(UserPrincipal currentUser, Long id);

	public BkuDto uploadFile(UserPrincipal currentUser, Long id, MultipartFile file);

    public DownloadFileResponse downloadFile(UserPrincipal currentUser, Long id);
}
