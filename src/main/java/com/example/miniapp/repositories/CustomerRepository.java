package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE c.email LIKE CONCAT('%', :domain)")
    List<Customer> findByEmailEndingWith(@Param("domain") String domain);
    @Query("SELECT c FROM Customer c WHERE c.phoneNumber LIKE CONCAT(:prefix, '%')")
    List<Customer> findByPhoneNumberStartingWith(@Param("prefix") String prefix);
}
