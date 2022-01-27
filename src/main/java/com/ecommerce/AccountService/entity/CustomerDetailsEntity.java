package com.ecommerce.AccountService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_details_tab")
public class CustomerDetailsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String firstName;
    private  String lastName;

    @Column(unique=true)
    private  String email ;
    @Column(unique=true)
    private String  mobileNumber;
    private  String  password;

    @OneToMany(mappedBy = "customerDetailsEntity")
    private List<CustomerAddressEntity> customerAddressEntityList;


    public CustomerDetailsEntity(String firstName, String lastName, String email, String mobileNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

}
