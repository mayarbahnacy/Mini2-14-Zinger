package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 8.2.2.1 Add Customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // 8.2.2.2 Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 8.2.2.3 Get Customer By ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    // 8.2.2.4 Update Customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepository.save(customer);
        }).orElse(null);
    }

    // 8.2.2.5 Delete Customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // 8.2.2.6 Find Customers By Email Domain
    public List<Customer> findCustomersByEmailDomain(String domain) {
        return customerRepository.findByEmailEndingWith(domain);
    }

    // 8.2.2.7 Find Customers By Phone Prefix
    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return customerRepository.findByPhoneNumberStartingWith(prefix);
    }
}
