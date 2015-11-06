package org.sergey.javabrains.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.sergey.javabrains.dao.CustomerDAO;
import org.sergey.javabrains.dao.CustomerDAOImpl;
import org.sergey.javabrains.domain.Customer;
import org.sergey.javabrains.utils.PreloadUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerDAOTest {
	
	AnnotationConfigApplicationContext context;
	
	@Test
	public void insertTeamsAssignedToOrganization() {
		
		context = new AnnotationConfigApplicationContext();
		context.register(PreloadUtil.class);
		context.register(CustomerDAOImpl.class);
		context.refresh();
		@SuppressWarnings("deprecation")
		Customer customer = new Customer("testFirstName", "testLastName", new Date(1975,05,18), "testUsername", "testPassword");
		CustomerDAO customerDAO = (CustomerDAO)context.getBean("customerDAO");
		Long customerId = customerDAO.create(customer);
		Customer customerRetrieved = customerDAO.getCustomerById(customerId);
		assertEquals(customer.getLastName(), customerRetrieved.getLastName());

		
	}

}