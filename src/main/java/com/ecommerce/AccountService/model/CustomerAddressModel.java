package com.ecommerce.AccountService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressModel {
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private  String code;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private  String state;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private String  city;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private Boolean  shippingAddress;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private Boolean billingAddress;

}