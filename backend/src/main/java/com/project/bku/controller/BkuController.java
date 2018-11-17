package com.project.bku.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.project.bku.excelreader.Bku;
import com.project.bku.payload.DownloadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.bku.payload.BkuDto;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.BkuService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/api")
public class BkuController {

	@Autowired
	BkuService bkuServiceImpl;
	
	@GetMapping("/bku/{id}")
	public BkuDto getById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
		BkuDto bku =  bkuServiceImpl.getById(currentUser, id);
		return bku;
	}
	
	@GetMapping("/bku")
	public List<BkuDto> getAll(@CurrentUser UserPrincipal currentUser) {
		List<BkuDto> list =  bkuServiceImpl.getAllBku(currentUser);
		return list;
	}
	
	@PostMapping("/bku")
	public BkuDto save(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody BkuDto entity) {
		return bkuServiceImpl.save(currentUser, entity);
	}

	@PostMapping("/bku/insertFile")
	public BkuDto insertFile(@CurrentUser UserPrincipal currentUser, @Valid @RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		return bkuServiceImpl.uploadFile(currentUser, id, file);
	}
	
	@PutMapping("/bku")
	public BkuDto update(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody BkuDto entity) {
		return bkuServiceImpl.update(currentUser, entity);
	}
	
	@DeleteMapping("/bku/{id}")
	public void delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
		bkuServiceImpl.delete(currentUser, id);
	}

    @GetMapping("/bku/download/{id}")
    public ResponseEntity<Resource> downloadFile(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        // Load file from database
        DownloadFileResponse bku = bkuServiceImpl.downloadFile(currentUser, id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(bku.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + bku.getFileName() + "\"")
                .body(new ByteArrayResource(bku.getData()));
    }

    @PostMapping("/bkuList")
    public List<Bku> saveExcel(@CurrentUser UserPrincipal currentUser, @Valid @RequestParam("file") MultipartFile file) throws IOException {
        return bkuServiceImpl.saveExcel(currentUser, file);
    }
}