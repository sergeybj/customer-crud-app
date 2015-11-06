package org.sergey.javabrains.service;

import java.util.List;

import org.sergey.javabrains.domain.Customer;

public interface CustomerService {
	
	Long create(Customer customer);
	
	Customer getCustomerById(Long id);
	
	List<Customer> getCustomerList();
	
	void deleteCustomerById(Long id);
	
	Long modifyCustomer(Customer customer);

}
