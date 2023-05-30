package com.minhdv.tutorial.springboot3.services;

import com.minhdv.tutorial.springboot3.model.Customer;

import java.util.List;
import java.util.UUID;

/**
 * CREATE BY MinhDV
 */
public interface CustomerService {
    Customer getCustomerById(UUID uuid);

    List<Customer> getAllCustomers();

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteCustomerById(UUID customerId);

    void patchCustomerById(UUID customerId, Customer customer);
}
