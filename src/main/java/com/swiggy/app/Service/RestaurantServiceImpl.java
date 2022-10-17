package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.RestaurantRepository;
import com.swiggy.app.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private RestaurantRepository restaurantRepo;

	public RestaurantServiceImpl(RestaurantRepository restaurantRepo) {
		this.restaurantRepo = restaurantRepo;
	}

	@Override
	public List<Restaurant> getAllRestauranats() {
		return restaurantRepo.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		return restaurantRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
		Boolean exists = restaurantRepo.existsById(id);
		if (exists) {
			return restaurantRepo.save(restaurant);
		} 
		return null;
	}

	@Override
	public Restaurant deleteRestaurant(Long id) {
		restaurantRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		Restaurant rest = restaurantRepo.findById(id).get();
		restaurantRepo.deleteById(id);
		return rest;
	}
	
	public int getTotalRatings(Restaurant restaurant) {
		return 1;
	}

	@Override
	public Long countRestaurants() {
		return restaurantRepo.count();
	}

	@Override
	public List<Restaurant> findByRating(double avgRating) {
		return restaurantRepo.findByRating(avgRating);
	}

	@Override
	public List<Restaurant> findByType(String type) {
		return restaurantRepo.findByType(type);
	}
	
}
