package org.sergey.javabrains.service;

import java.util.List;

import org.sergey.javabrains.dao.CustomerDAO;
import org.sergey.javabrains.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;

	public Long create(Customer customer) {
		return customerDAO.create(customer);
	}

	public Customer getCustomerById(Long id) {
		return customerDAO.getCustomerById(id);
	}

	public List<Customer> getCustomerList() {
		return customerDAO.getCustomerList();
	}

	public void deleteCustomerById(Long id) {
		customerDAO.deleteCustomerById(id);
	}

	public Long modifyCustomer(Customer customer) {
		return customerDAO.modifyCustomer(customer);
	}
	
	
	

}
