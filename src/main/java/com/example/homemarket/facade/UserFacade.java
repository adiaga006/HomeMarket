package com.example.homemarket.facade;

import com.example.homemarket.dtos.UserDTO;
import com.example.homemarket.dtos.response.UserForgetPasswordResponse;
import com.example.homemarket.dtos.response.UserLoginResponse;
import com.example.homemarket.dtos.response.UserRegisterOtpRespone;
import com.example.homemarket.dtos.response.UserResetPasswordResponse;
import com.example.homemarket.entities.User;
import com.example.homemarket.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserFacade {

    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<User> register(UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.OK);
    }

    public ResponseEntity<UserLoginResponse> login(UserLoginResponse userLoginResponse) {
        UserLoginResponse response = userService.login(userLoginResponse);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserRegisterOtpRespone> otp(UserRegisterOtpRespone userRegisterOtpRespone) {
        UserRegisterOtpRespone response = userService.otp(userRegisterOtpRespone);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserForgetPasswordResponse> forgetPassword(UserForgetPasswordResponse userForgetPasswordResponse) {
        UserForgetPasswordResponse response = userService.forgetPassword(userForgetPasswordResponse);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserResetPasswordResponse> resetPassword(UserResetPasswordResponse userResetPasswordResponse) {
        UserResetPasswordResponse response = userService.resetPassword(userResetPasswordResponse);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserDTO> getUser(Integer userId) {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    public ResponseEntity<List<UserDTO>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

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
