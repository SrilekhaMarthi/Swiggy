package com.swiggy.app.Customer;

import java.util.List;

public interface CustomerService {
	List<Customer> getUsers();
	
	Customer getUserById(Long id);
	
	Customer addUser(Customer user);
	
	String deleteUserById(Long id);
	
}
