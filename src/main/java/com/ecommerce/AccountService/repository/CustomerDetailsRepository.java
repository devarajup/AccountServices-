package com.ecommerce.AccountService.repository;

import com.ecommerce.AccountService.entity.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
    @Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity,Integer> {


    CustomerDetailsEntity findByEmail(String email);
//    @Query("select customer from CustomerDetailsEntity customer where username=:username or mobileNumber=:mobileNumber or email=:email")
    Optional<CustomerDetailsEntity> findByMobileNumberOrEmail(String mobileNumber, String email);

}
