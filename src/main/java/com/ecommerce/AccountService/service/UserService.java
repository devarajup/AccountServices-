package com.ecommerce.AccountService.service;


import com.ecommerce.AccountService.CustomizedExceptionHandling.Exceptions.UserNotFondException;
import com.ecommerce.AccountService.entity.CustomerDetailsEntity;
import com.ecommerce.AccountService.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CustomerDetailsRepository repo;

    public CustomerDetailsEntity findByEmailId(String emailId) {
        return repo.findByEmail(emailId).get();
    }

    public UserDetails loadUserByUsername(String emailId) {
        CustomerDetailsEntity user = findByEmailId(emailId);
        return new org.springframework.security.core.userdetails.User(
                emailId, user.getPassword(), new HashSet<>()
        );
    }
}