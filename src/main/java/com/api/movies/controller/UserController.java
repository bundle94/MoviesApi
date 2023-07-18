package com.api.movies.controller;

import com.api.movies.model.BaseResponse;
import com.api.movies.model.LoginRequest;
import com.api.movies.model.Review;
import com.api.movies.model.User;
import com.api.movies.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    private UserServices userServices;
    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping(value = "/login", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<User>> signIn(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userServices.login(request));
    }

    @PostMapping(value = "/createAccount", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createAccount(@RequestBody User user) {
        return new ResponseEntity<>(userServices.createAccount(user),CREATED);
    }
}
