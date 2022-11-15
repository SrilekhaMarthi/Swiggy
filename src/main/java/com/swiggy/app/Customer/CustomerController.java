package com.swiggy.app.Customer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;

@RestController
@RequestMapping("/api/user")
public class CustomerController {

	@Autowired
	private CustomerService userService;
	@Autowired
	private GResponse gResponse;

	@GetMapping("/all")
	public GResponse getAllUsers() {
		List<Customer> user = userService.getUsers();
		gResponse.setData(user);
		return gResponse;
	}

	@GetMapping("/{id}")
	public GResponse getUserById(@PathVariable Long id) {
		Customer user = userService.getUserById(id);
		gResponse.setData(user);
		return gResponse;
	}

	@PostMapping
	public GResponse addUser(@Valid @RequestBody Customer user) {
		Customer user1 = userService.addUser(user);
		gResponse.setData(user1);
		return gResponse;
	}

	@DeleteMapping("/{id}")
	public GResponse deleteUser(@PathVariable Long id) {
		String msg = userService.deleteUserById(id);
		gResponse.setData(msg);
		return gResponse;
	}

}
