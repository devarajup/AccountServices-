package com.ecommerce.AccountService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_address_tab")
public class CustomerAddressEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    private  String code;
    private  String state;
    private String  city;
    private Boolean  shippingAddress;
    private Boolean billingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id_fk")
    private   CustomerDetailsEntity customerDetailsEntity;

    public CustomerAddressEntity(String code, String state, String city, Boolean shippingAddress, Boolean billingAddress) {
        this.code = code;
        this.state = state;
        this.city = city;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }


}
