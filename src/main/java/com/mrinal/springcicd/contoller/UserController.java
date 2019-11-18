package com.mrinal.springcicd.contoller;

import com.mrinal.springcicd.model.GenericResponse;
import com.mrinal.springcicd.model.User;
import com.mrinal.springcicd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.net.www.content.text.Generic;
import sun.reflect.generics.factory.GenericsFactory;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private GenericResponse userResponse;
    @Autowired
    private UserService userService;
    private List<User> usersList = new ArrayList<User>();

    @GetMapping("/users")
    public  ResponseEntity<GenericResponse> getUsers(){

         userResponse.setData(usersList);
         userResponse.setMessage("User details fetched successfully");
         userResponse.setStatus(200);

       return new ResponseEntity<GenericResponse>(userResponse, HttpStatus.OK);
    }
    @PostMapping("/users/create")
    public ResponseEntity<GenericResponse> addUsers(@Valid @RequestBody User user){
        if(userService.validateEmailUnique(user,usersList) == false){
            return new ResponseEntity<GenericResponse>(new GenericResponse(200,"Email id Should be unique.try changing the email id.",null),HttpStatus.BAD_REQUEST);
        }else{
            usersList.add(user);
            return new ResponseEntity<GenericResponse>(new GenericResponse(200,"User created successfully",null),HttpStatus.CREATED);
        }

    }
    @PostMapping("/login")
    public ResponseEntity<GenericResponse> login(@RequestBody User user){
        User receivedUser = new User();
        receivedUser = user;
        return new ResponseEntity<GenericResponse>(new GenericResponse(200,"Login Successful",receivedUser),HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<GenericResponse> logout(){
        return new ResponseEntity<GenericResponse>(new GenericResponse(200,"Login Successful",null),HttpStatus.OK);
    }
    @GetMapping("/healthcheck")
    public ResponseEntity<GenericResponse> healthcheck(){
        return new ResponseEntity<GenericResponse>(new GenericResponse(200,"Application is up and running",null),HttpStatus.OK);
    }
}
