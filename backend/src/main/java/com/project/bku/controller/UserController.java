package com.project.bku.controller;
import javax.validation.Valid;

import com.project.bku.payload.PagedResponse;
import com.project.bku.service.UserService;
import com.project.bku.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.bku.exception.BadRequestException;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.User;
import com.project.bku.payload.UserIdentityAvailability;
import com.project.bku.payload.UserUpdateRequest;
import com.project.bku.repository.UserRepository;
import com.project.bku.security.CurrentUser;
import com.project.bku.security.UserPrincipal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userServiceImpl;

	@GetMapping("/user/me")
	@PreAuthorize("hasAnyRole('BENDAHARA','PEMERIKSA')")
	public User getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		return userServiceImpl.getCurrentUser(currentUser);
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		return userServiceImpl.checkUsernameAvailability(username);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		return userServiceImpl.checkEmailAvailability(email);
	}

	@GetMapping("/users/{username}")
	public User getUserProfile(@PathVariable(value = "username") String username) {
		return userServiceImpl.getUserProfile(username);
	}

	@GetMapping("/users")
	public PagedResponse<User> getAllUserProfile(@CurrentUser UserPrincipal currentUser,
                                                 @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                 @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
		return userServiceImpl.getAllUserProfile(page, size);
	}

	@PutMapping("users")
	@PreAuthorize("hasRole('BENDAHARA')")
	public User updateUserProfile(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody UserUpdateRequest userDetails)
			throws Exception {
		return userServiceImpl.updateUserProfile(currentUser,userDetails);
	}
	
	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    userServiceImpl.deleteUser(userId);
	    return ResponseEntity.ok().build();
	}
}
