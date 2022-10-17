package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> getAllRestauranats();
	
	Restaurant getRestaurantById(Long id);
	
	Restaurant addRestaurant(Restaurant restaurant);
	
	Restaurant updateRestaurant(Restaurant restaurant,Long id);
	
	Restaurant deleteRestaurant(Long id);

	Long countRestaurants();

	int getTotalRatings(Restaurant restaurant);
	
	List<Restaurant> findByRating(double avgRating);
	
	List<Restaurant> findByType(String type);
}
