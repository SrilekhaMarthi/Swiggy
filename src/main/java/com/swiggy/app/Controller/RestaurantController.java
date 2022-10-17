package com.swiggy.app.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;
import com.swiggy.app.Service.RestaurantService;
import com.swiggy.app.model.Restaurant;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
	
	private RestaurantService restaurantService;
	private GResponse gResponse;
	
	
	public RestaurantController(RestaurantService restaurantService,GResponse gResponse) {
		this.restaurantService=restaurantService;
		this.gResponse=gResponse;
		gResponse.setStatus(HttpStatus.OK.value());

	}
	
	@GetMapping("/all")
	public GResponse getAllRestauranats() {
		gResponse.setData(restaurantService.getAllRestauranats());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getRestaurantById(@PathVariable Long id) {
		gResponse.setData(restaurantService.getRestaurantById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		gResponse.setData(restaurantService.addRestaurant(restaurant));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateRestaurant(@Valid @RequestBody Restaurant restaurant,@PathVariable Long id) {
		gResponse.setData(restaurantService.updateRestaurant(restaurant, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteRestaurant(@PathVariable Long id) {
		gResponse.setData(restaurantService.deleteRestaurant(id));
		System.out.println("Delete:"+gResponse);
		return gResponse;
	}
	
	@GetMapping("/count")
	public GResponse countOfRestaurants() {
		gResponse.setData(restaurantService.countRestaurants());
		System.out.println("Count:"+gResponse);
		return gResponse;
	}
	
	@GetMapping("/rating")
	public GResponse getRestaurantByRating(@RequestParam(name="rating") double avgRating) {
		gResponse.setData(restaurantService.findByRating(avgRating));
		return gResponse;
	}
	
	@GetMapping("/type")
	public GResponse getRestaurantByType(@RequestParam(name="type") String type) {
		gResponse.setData(restaurantService.findByType(type));
		return gResponse;
	}
		
}
