package com.project.bku.controller;
import javax.validation.Valid;

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
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasAnyRole('ROLE_BENDAHARA','ROLE_PEMERIKSA')")
	public User getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		User user = userRepository.findById(currentUser.getId()).orElseThrow(() -> new BadRequestException("Tidak ada user"));
		return user;
	}
	
	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/users/{username}")
	public User getUserProfile(@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		return user;
	}

	@GetMapping("/users")
	public Page<User> getAllUserProfile(Pageable pageable) {
		Page<User> list = userRepository.findAll(pageable);
		return list;
	}

	@PutMapping("users")
	@PreAuthorize("hasRole('BENDAHARA')")
	public User updateUserProfile(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody UserUpdateRequest userDetails)
			throws Exception {
		User user = userRepository.findById(userDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "username", userDetails.getUsername()));
		if (currentUser.getId().equals(userDetails.getId())) {
			user.setName(userDetails.getName());
			user.setUsername(userDetails.getUsername());
			user.setEmail(userDetails.getEmail());
			user.setTahunAktif(userDetails.getTahunAktif());
			return userRepository.save(user);
		} else {
			throw new BadRequestException("Anda tidak diijinkan mengedit profile orang lain.");
		}
	}
	
	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	    userRepository.delete(user);
	    return ResponseEntity.ok().build();
	}
}
