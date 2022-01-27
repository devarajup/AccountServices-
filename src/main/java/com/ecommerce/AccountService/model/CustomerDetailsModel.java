package com.ecommerce.AccountService.model;

import com.ecommerce.AccountService.CustomValidations.EMailValidation;
import com.ecommerce.AccountService.CustomValidations.MobileValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsModel {



    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private String firstName;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    private  String lastName;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")

    private  String email ;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    @MobileValidation
    private String  mobileNumber;
    @NotNull(message = "it is not null")
    @NotEmpty(message = "it is not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String  password;


    private List<CustomerAddressModel> customerAddressModel;

    public CustomerDetailsModel(String firstName, String lastName, String email, String mobileNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }


}
