package com.example.homemarket.controller;

import com.example.homemarket.dtos.OrderDTO;
import com.example.homemarket.dtos.UserDTO;
import com.example.homemarket.dtos.response.UserForgetPasswordResponse;
import com.example.homemarket.dtos.response.UserLoginResponse;
import com.example.homemarket.dtos.response.UserRegisterOtpRespone;
import com.example.homemarket.dtos.response.UserResetPasswordResponse;
import com.example.homemarket.entities.Order;
import com.example.homemarket.entities.User;
import com.example.homemarket.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody  UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginResponse userLoginResponse){
        UserLoginResponse response = userService.login(userLoginResponse);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @PostMapping("/otp")
    public ResponseEntity<UserRegisterOtpRespone> otp(@RequestBody UserRegisterOtpRespone userRegisterOtpRespone){
        UserRegisterOtpRespone response = userService.otp(userRegisterOtpRespone);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @PostMapping("/forgetPassword")
    public ResponseEntity<UserForgetPasswordResponse> forgetPassword(@RequestBody UserForgetPasswordResponse userForgetPasswordResponse){
        UserForgetPasswordResponse response = userService.forgetPassword(userForgetPasswordResponse);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @PostMapping("/resetPassword")
    public ResponseEntity<UserResetPasswordResponse> resetPassword(@RequestBody UserResetPasswordResponse userResetPasswordResponse){
        UserResetPasswordResponse response = userService.resetPassword(userResetPasswordResponse);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @GetMapping("/getuser")
    public ResponseEntity<UserDTO> getUser(@RequestParam("key") Integer userId){
        return new ResponseEntity<>(userService.getUser(userId),HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/iterator")
    public ResponseEntity<List<UserDTO>> getUsersIterator() {
        List<UserDTO> users = userService.getAllUser();
        List<UserDTO> usersList = new ArrayList<>();
        Iterator<UserDTO> iterator = users.iterator();
        while (iterator.hasNext()) {
            UserDTO user = iterator.next();
            usersList.add(user);
        }
        return ResponseEntity.ok().body(usersList);
    }
}
