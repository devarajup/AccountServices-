package com.ecommerce.AccountService.controllers;

import com.ecommerce.AccountService.model.CustomerAddressModel;
import com.ecommerce.AccountService.model.CustomerDetailsModel;
import com.ecommerce.AccountService.model.UserRequest;
import com.ecommerce.AccountService.model.UserResponse;
import com.ecommerce.AccountService.service.CustomerDetailsService;
import com.ecommerce.AccountService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class CustomerRestController {

    @Autowired
    private CustomerDetailsService customerDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil util;

    @PostMapping("/add-customer")
    public ResponseEntity<String> addCustomerDeatails(@Valid @RequestBody CustomerDetailsModel model)  {
        return   customerDetailsService.addCustomerDeatails(model);

    }

    @PostMapping("/add-customer-address")
    public String addAdressToCustomer(@RequestHeader(
            value = "Authorization",
            required = true)   String authorization, @RequestBody CustomerAddressModel model) {
        return customerDetailsService.addAddressToCustomer(authorization, model);
    }

    @GetMapping("/get-customer-details")
    public CustomerDetailsModel getFullCustomerDetails(@RequestHeader(
            value = "Authorization",
            required = true)   String authorization) {
        return customerDetailsService.getFullCustomerDetails(authorization);
    }


    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(
            @RequestBody UserRequest userRequest
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getEmail(), userRequest.getPassword())
        );

        String token = util.generateToken(userRequest.getEmail());
        return ResponseEntity.ok(new UserResponse(token));
    }

    @PostMapping("/home")
    public ResponseEntity<String> securedResource() {
        return ResponseEntity.ok("WELCOME TO SECURED RESOURCE AFTER LOGIN!");
    }

    @GetMapping("/get-mail")
    public  String getMail(@RequestParam("token") String token ){

        return customerDetailsService.getEmailByToken(token);
    }
}
