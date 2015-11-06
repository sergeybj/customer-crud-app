package org.sergey.javabrains.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.sergey.javabrains.domain.Customer;
import org.sergey.javabrains.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@SuppressWarnings("deprecation")
@Service
@ResultPath(value = "/")
@ParentPackage(value = "struts-default")
public class CustomerJSONAction {

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	@Autowired
	CustomerService ñustomerService;

	@Action(value = "/actions/customerListAction", results = { @Result(type = "stream", name = "SUCCESS", params = {
			"contentType", "text/plain", "inputName", "inputStream", }) })
	public String customerListJson() {

		Gson gson = new Gson();
		List<Customer>list = ñustomerService.getCustomerList();
		String result = gson.toJson(list);
		inputStream = new StringBufferInputStream(result);
		return "SUCCESS";
	}
	

}
