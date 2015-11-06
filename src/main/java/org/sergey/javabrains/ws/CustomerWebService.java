package org.sergey.javabrains.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sergey.javabrains.dao.CustomerDAOImpl;
import org.sergey.javabrains.domain.Customer;
import org.sergey.javabrains.utils.PreloadUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebService(name="CustomerWebService")
public class CustomerWebService  {
	
	AnnotationConfigApplicationContext context;
	
	@WebMethod
	public Customer getCustomerById(Long id)
	{
		context = new AnnotationConfigApplicationContext();
		context.register(PreloadUtil.class);
		context.register(CustomerDAOImpl.class);
		context.refresh();
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Customer ñustomer = (Customer)session.load(Customer.class, id);
		return ñustomer;
		
	}
}
