package com.mrinal.springcicd.service;

import com.mrinal.springcicd.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public boolean validateEmailUnique(User user, List<User> userList);

}
