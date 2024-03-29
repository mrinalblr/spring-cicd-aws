package com.mrinal.springcicd.contoller;

import com.mrinal.springcicd.model.GenericResponse;
import com.mrinal.springcicd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.factory.GenericsFactory;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private GenericResponse userResponse;

    @GetMapping("/users")
    public  ResponseEntity<GenericResponse> getUsers(){
         User user =  new User();
         user.setName("Mrinal Deo");
         user.setContactNo("7358411170");
         user.setEmailId("mrinal.deo@gmail.com");
         ArrayList<String> userAddress = new ArrayList<>();
         userAddress.add("Flat-111,ABC APARTMENT,XYZ LANE,BENEGALURU-560001.");
        userAddress.add("Flat-201,DEF APARTMENT,ABC LANE,RANCHI.");
         user.setAddress(userAddress);

         userResponse.setData(user);
         userResponse.setMessage("Address fetched successfully");
         userResponse.setStatus(200);


       return new ResponseEntity<GenericResponse>(userResponse, HttpStatus.OK);
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
