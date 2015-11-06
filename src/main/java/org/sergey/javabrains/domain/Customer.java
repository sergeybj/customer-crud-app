package org.sergey.javabrains.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="customer_id_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_sequence")
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	
	
	public Customer() {}

	public Customer(String firstName, String lastName,
			Date birthDate, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", username=" + username + ", password="
				+ password + "]";
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
