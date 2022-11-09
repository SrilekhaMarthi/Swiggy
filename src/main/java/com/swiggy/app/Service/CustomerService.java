package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Customer;

public interface CustomerService {
	List<Customer> getUsers();
	
	Customer getUserById(Long id);
	
	Customer addUser(Customer user);
	
	String deleteUserById(Long id);
	
}

