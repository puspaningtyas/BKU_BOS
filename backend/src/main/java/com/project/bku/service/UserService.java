package com.project.bku.service;

import com.project.bku.model.User;
import com.project.bku.payload.PagedResponse;
import com.project.bku.payload.UserIdentityAvailability;
import com.project.bku.payload.UserUpdateRequest;
import com.project.bku.security.UserPrincipal;

import javax.validation.Valid;

public interface UserService {

    public User getCurrentUser(UserPrincipal currentUser);

    public UserIdentityAvailability checkUsernameAvailability(String username);

    public UserIdentityAvailability checkEmailAvailability(String email);

    public User getUserProfile(String username);

    public PagedResponse<User> getAllUserProfile(int page, int size);

    public User updateUserProfile(UserPrincipal currentUser, UserUpdateRequest userDetails)
            throws Exception;

    public void deleteUser(Long userId);
}
