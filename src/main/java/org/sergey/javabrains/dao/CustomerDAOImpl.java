package org.sergey.javabrains.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sergey.javabrains.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Long create(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Long id = (Long) session.save(customer);
		tx.commit();
		session.close();
		return id;
	}

	public Customer getCustomerById(Long id) {
		Session session = sessionFactory.openSession();
		Customer ñustomer = (Customer) session.load(Customer.class, id);
		return ñustomer;
	}

	public List<Customer> getCustomerList() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> list = (List<Customer>) session.createQuery(
				"from Customer").list();

		for (Customer customer : list) {
			System.out.println(customer);
		}
		return list;
	}

	public void deleteCustomerById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Customer ñustomer = (Customer) session.load(Customer.class, id);
		session.delete(ñustomer);
		tx.commit();
		session.close();
	}

	public Long modifyCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(customer);
		tx.commit();
		session.close();
		return customer.getCustomerId();
	}
	
	@Bean(name = "customerDAO")
	CustomerDAO getCustomerDAO() {
		return this;
	}

}
