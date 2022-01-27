package com.ecommerce.AccountService.repository;

import com.ecommerce.AccountService.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity,Integer> {

}
