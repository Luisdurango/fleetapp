package com.springconsole.fleetapp.services;

import com.springconsole.fleetapp.models.User;
import com.springconsole.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userService;
    @Autowired
    BCryptPasswordEncoder encoder;

    public void save(User user){

        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);


    }

}
