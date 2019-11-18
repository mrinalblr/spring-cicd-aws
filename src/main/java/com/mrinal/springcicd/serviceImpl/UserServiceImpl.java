package com.mrinal.springcicd.serviceImpl;

import com.mrinal.springcicd.model.User;
import com.mrinal.springcicd.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public boolean validateEmailUnique(User user, List<User> userList) {
        boolean valid = true;
        if(userList!=null){
            for (User u:userList) {
                if((u.getEmailId()).equals(user.getEmailId())){
                    System.out.println(u.getEmailId()+"::"+user.getEmailId());
                    valid = false;
                }
            }
        }

        return valid;
    }
}
