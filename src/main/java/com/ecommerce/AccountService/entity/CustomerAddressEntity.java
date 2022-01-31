package com.ecommerce.AccountService.entity;

import com.ecommerce.AccountService.util.CustomCustomerIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_address_tab")
public class CustomerAddressEntity{


    @Id
    @GenericGenerator(name = "address_id_gen",
            strategy = "com.ecommerce.AccountService.util.CustomCustomerIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = CustomCustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "AID"),
                    @org.hibernate.annotations.Parameter(name = CustomCustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") }
    )
    @GeneratedValue(generator = "address_id_gen",strategy = GenerationType.IDENTITY)

    private String aid;
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
