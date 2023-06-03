package com.example.homemarket.controller;

import com.example.homemarket.dtos.UserDTO;
import com.example.homemarket.dtos.response.UserForgetPasswordResponse;
import com.example.homemarket.dtos.response.UserLoginResponse;
import com.example.homemarket.dtos.response.UserRegisterOtpRespone;
import com.example.homemarket.dtos.response.UserResetPasswordResponse;
import com.example.homemarket.entities.User;
import com.example.homemarket.facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO) {
        return userFacade.register(userDTO);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginResponse userLoginResponse) {
        return userFacade.login(userLoginResponse);
    }

    @CrossOrigin
    @PostMapping("/otp")
    public ResponseEntity<UserRegisterOtpRespone> otp(@RequestBody UserRegisterOtpRespone userRegisterOtpRespone) {
        return userFacade.otp(userRegisterOtpRespone);
    }

    @CrossOrigin
    @PostMapping("/forgetPassword")
    public ResponseEntity<UserForgetPasswordResponse> forgetPassword(@RequestBody UserForgetPasswordResponse userForgetPasswordResponse) {
        return userFacade.forgetPassword(userForgetPasswordResponse);
    }

    @CrossOrigin
    @PostMapping("/resetPassword")
    public ResponseEntity<UserResetPasswordResponse> resetPassword(@RequestBody UserResetPasswordResponse userResetPasswordResponse) {
        return userFacade.resetPassword(userResetPasswordResponse);
    }

    @CrossOrigin
    @GetMapping("/getuser")
    public ResponseEntity<UserDTO> getUser(@RequestParam("key") Integer userId) {
        return userFacade.getUser(userId);
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return userFacade.getAllUser();
    }

    @GetMapping("/iterator")
    public ResponseEntity<List<UserDTO>> getUsersIterator() {
        return userFacade.getUsersIterator();
    }
}
