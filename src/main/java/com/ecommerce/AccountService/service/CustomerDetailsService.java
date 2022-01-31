package com.ecommerce.AccountService.service;

import com.ecommerce.AccountService.entity.CustomerAddressEntity;
import com.ecommerce.AccountService.entity.CustomerDetailsEntity;
import com.ecommerce.AccountService.model.CustomerAddressModel;
import com.ecommerce.AccountService.model.CustomerDetailsModel;
import com.ecommerce.AccountService.repository.CustomerAddressRepository;
import com.ecommerce.AccountService.repository.CustomerDetailsRepository;
import com.ecommerce.AccountService.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerDetailsService {
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private JwtUtil util;

    public String addCustomerDeatails(CustomerDetailsModel model) {
        if (!customerDetailsRepository.findByMobileNumberOrEmail(model.getMobileNumber(), model.getEmail()).isPresent()) {
            model.setPassword(encoder.encode(model.getPassword()));
            CustomerDetailsEntity entity = customerDetailsRepository.save(getEntity(model));

            return "Customer Details saved Successfully" +
                    "\n\tCustomer ID\t:"+entity.getCustomerId()+
                    "\n\tFull Name\t:"+entity.getFirstName() + " " + entity.getLastName() +
                    "\n\tEMail ID\t:" + entity.getEmail();
        }

        return "Duplicate not allowed";
    }


    public String addAddressToCustomer(String Authorization, CustomerAddressModel model) {
        String emailId = util.getUserName(Authorization);
        System.out.println(emailId);
        if (customerDetailsRepository.findByEmail(emailId) != null) {
            CustomerAddressEntity customerAddressEntity = getCustomerAddressEntity(model);
            customerAddressEntity.setCustomerDetailsEntity(customerDetailsRepository.findByEmail(emailId));
            customerAddressRepository.save(customerAddressEntity);
        }
        return "address be added to  customer ID " + emailId;
    }

    public CustomerDetailsModel getFullCustomerDetails(String authorization) {
        return getModelx(customerDetailsRepository.findByEmail(util.getUserName(authorization)));

    }


    private static CustomerAddressEntity getCustomerAddressEntity(CustomerAddressModel model) {
        return new CustomerAddressEntity(model.getCode(),
                model.getState(),
                model.getCity(),
                model.getShippingAddress(),
                model.getBillingAddress()
        );
    }

    private static CustomerAddressModel getCustomerAddressModel(CustomerAddressEntity entity) {
        return new CustomerAddressModel(entity.getCode(),
                entity.getState(),
                entity.getCity(),
                entity.getShippingAddress(),
                entity.getBillingAddress());


    }

    private static CustomerDetailsEntity getEntity(CustomerDetailsModel customerModel) {
        return new CustomerDetailsEntity(customerModel.getFirstName(),
                customerModel.getLastName(),
                customerModel.getEmail(),
                customerModel.getMobileNumber(),
                customerModel.getPassword()

        );
    }

    private static CustomerDetailsModel getModel(CustomerDetailsEntity customerEntity) {
        return new CustomerDetailsModel(customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getEmail(),
                customerEntity.getMobileNumber(),
                customerEntity.getPassword());

    }

    private static CustomerDetailsModel getModelx(CustomerDetailsEntity customerEntity) {
        List<CustomerAddressModel> addressModels = customerEntity
                .getCustomerAddressEntityList()
                .stream()
                .map(entity -> getCustomerAddressModel(entity))
                .collect(Collectors.toList());

        return new CustomerDetailsModel(customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getEmail(),
                customerEntity.getMobileNumber(),
                customerEntity.getPassword(),
                addressModels);

    }
}
