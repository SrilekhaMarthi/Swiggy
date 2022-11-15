package com.swiggy.app.Customer;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository userRepo;
	
	@Override
	public List<Customer> getUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public Customer getUserById(Long id) {
		if (!Objects.isNull(id)) {
			return userRepo.findById(id).get();
		}
		else {
			throw new NoSuchElementException();
		}
		
	}
	
	@Override
	public Customer addUser(Customer user) {
		return userRepo.save(user);
	}
	
	@Override
	public String deleteUserById(Long id) {
		if (!Objects.isNull(id)) {
			userRepo.deleteById(id);
			return "deleted Successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
	}

	
}
