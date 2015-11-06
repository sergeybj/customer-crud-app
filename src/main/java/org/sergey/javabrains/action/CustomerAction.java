package org.sergey.javabrains.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.sergey.javabrains.domain.Customer;
import org.sergey.javabrains.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

@SuppressWarnings("deprecation")
@Controller
@ResultPath(value = "/")
@ParentPackage(value = "tiles-default")
@Validation
public class CustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	CustomerService ñustomerService;

	private Long savedId;
	private String customerId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String birthDate;

	private Customer customerToModify;

	public Customer getCustomerToModify() {
		return customerToModify;
	}

	public void setCustomerToModify(Customer customerToModify) {
		this.customerToModify = customerToModify;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public Long getSavedId() {
		return savedId;
	}

	public void setSavedId(Long savedId) {
		this.savedId = savedId;
	}

	@RequiredStringValidator(message = "First name field cannot be empty")
	@StringLengthFieldValidator(minLength = "5", message = "First name must contain at least 3 charachters")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@RequiredStringValidator(message = "Last name field cannot be empty")
	@StringLengthFieldValidator(minLength = "5", message = "Last name must contain at least 3 charachters")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	@RequiredStringValidator(message = "Username field cannot be empty")
	@StringLengthFieldValidator(minLength = "5", message = "Username must contain at least 3 charachters")
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(message = "Password field cannot be empty")
	@StringLengthFieldValidator(minLength = "5", message = "Password must contain at least 5 charachters")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthDate() {
		return birthDate;
	}

	@RequiredStringValidator(message = "Birth date field cannot be empty")
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@SkipValidation
	@Action(value = "/actions/createOrEditCustomerForm", results = { @Result(name = "SUCCESS", type = "tiles", location = "customerCreate") })
	public String createOrEditCustomerForm() {
		System.out.println("id = " + customerId);
		if (customerId != null)
			customerToModify = ñustomerService.getCustomerById(Long
					.parseLong(customerId));
		return "SUCCESS";
	}

	@SkipValidation
	@Action(value = "/actions/customerListPage", results = { @Result(name = "SUCCESS", type = "tiles", location = "customerList") })
	public String customerList() {
		return "SUCCESS";
	}

	@Action(value = "/actions/createOrEditCustomerAction", results = {
			@Result(name = "SUCCESS", type = "tiles", location = "successCreate"),
			@Result(name = "input", type = "tiles", location = "customerCreate") })
	public String createOrEditCustomerAction() {
		System.out.println("id = " + customerId);
		System.out.println("firstName = " + firstName);
		System.out.println("firstName.length() = " + firstName.length());

		Customer customer = new Customer();

		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUsername(username);
		customer.setPassword(password);
		DateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		try {
			customer.setBirthDate(sdf.parse(birthDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (customerId != null && !customerId.equals("")) {
			customer.setCustomerId(Long.parseLong(customerId));
			ñustomerService.modifyCustomer(customer);
		}

		savedId = ñustomerService.create(customer);

		System.out.println("savedId = " + savedId);
		return "SUCCESS";
	}

	@Action(value = "/actions/deleteCustomerAction", results = { @Result(name = "SUCCESS", type = "tiles", location = "customerList") })
	public String deleteCustomerAction() {
		ñustomerService.deleteCustomerById(Long.parseLong(customerId));

		return "SUCCESS";
	}



}
