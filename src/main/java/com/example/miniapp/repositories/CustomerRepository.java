package com.example.miniapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniapp.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailEndingWith(String domain);
    List<Customer> findByPhoneNumberStartingWith(String prefix);
}
