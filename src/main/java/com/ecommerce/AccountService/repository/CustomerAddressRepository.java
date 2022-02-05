package com.ecommerce.AccountService.repository;

import com.ecommerce.AccountService.entity.CustomerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressEntity,String> {
 @Query(value = "SELECT * FROM ecommerce_project_db.customer_address_tab WHERE customer_id_fk=:id",nativeQuery = true)
 List<CustomerAddressEntity> getCustomerAddress(String id);
}
