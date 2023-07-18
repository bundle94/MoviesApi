package com.api.movies.service;

import com.api.movies.model.BaseResponse;
import com.api.movies.model.LoginRequest;
import com.api.movies.model.User;
import com.api.movies.repository.UserRepository;
import com.api.movies.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public BaseResponse<User> login (LoginRequest request) {
        String hashedPassword = new PasswordEncoder().hashPassword(request.getPassword());
        User user = userRepository.fetchUserForLogin(request.getEmail(), hashedPassword);
        if(user != null) {
            return new BaseResponse("00", "Success", user);
        }
        return new BaseResponse("99", "Failed", null);
    }

    public BaseResponse createAccount (User user) {
        user.setPassword(new PasswordEncoder().hashPassword(user.getPassword()));
        userRepository.save(user);
        return new BaseResponse("00", "Created", null);
    }
}
