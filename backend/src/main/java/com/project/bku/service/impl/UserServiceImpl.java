package com.project.bku.service.impl;

import com.project.bku.exception.BadRequestException;
import com.project.bku.exception.ResourceNotFoundException;
import com.project.bku.model.User;
import com.project.bku.payload.PagedResponse;
import com.project.bku.payload.UserIdentityAvailability;
import com.project.bku.payload.UserUpdateRequest;
import com.project.bku.repository.UserRepository;
import com.project.bku.security.UserPrincipal;
import com.project.bku.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User getCurrentUser(UserPrincipal currentUser) {
        User user = userRepository.findById(currentUser.getId()).orElseThrow(() -> new BadRequestException("Tidak ada user"));
        return user;
    }

    @Override
    public UserIdentityAvailability checkUsernameAvailability(String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @Override
    public UserIdentityAvailability checkEmailAvailability(String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @Override
    public User getUserProfile(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return user;
    }

    @Override
    public PagedResponse<User> getAllUserProfile(int page, int size) {
        //create pageable
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<User> list = userRepository.findAll(pageable);

        List<User> bkuDtos = list.getContent().stream().map(lis -> modelMapper.map(lis, User.class)).collect(Collectors.toList());
        PagedResponse<User> pagedResponse = new PagedResponse<User>(bkuDtos, list.getNumber(), list.getSize(), list.getTotalElements(),
                list.getTotalPages(), list.isLast());
        return pagedResponse;
    }

    @Override
    public User updateUserProfile(UserPrincipal currentUser, UserUpdateRequest userDetails) throws Exception {
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

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
    }
}
