package com.example.RegisterLogin.Service;


import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.payload.response.LoginMesage;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.response.LoginResponse;

public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}