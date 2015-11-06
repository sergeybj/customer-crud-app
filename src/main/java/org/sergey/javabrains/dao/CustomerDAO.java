package org.sergey.javabrains.dao;

import java.util.List;

import org.sergey.javabrains.domain.Customer;

public interface CustomerDAO {
	
	Long create(Customer customer);
	
	Customer getCustomerById(Long id);
	
	List<Customer> getCustomerList();
	
	void deleteCustomerById(Long id);
	
	Long modifyCustomer(Customer customer);
	

}
