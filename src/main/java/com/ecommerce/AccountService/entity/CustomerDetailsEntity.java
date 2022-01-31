package com.ecommerce.AccountService.entity;

import com.ecommerce.AccountService.util.CustomCustomerIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import  org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_details_tab")
public class CustomerDetailsEntity {


    @Id
    @GenericGenerator(name = "customer_id_gen",
            strategy = "com.ecommerce.AccountService.util.CustomCustomerIdGenerator",
            parameters = {
            @Parameter(name = CustomCustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "CID"),
            @Parameter(name = CustomCustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") }
    )
    @GeneratedValue(generator = "customer_id_gen",strategy = GenerationType.IDENTITY)


    //    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String CustomerId;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobileNumber;
    private String password;

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
