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
		Restaurant restaurant1 = restaurantRepo.findById(id).get();
		if (restaurant1 != null) {
			if (restaurant.getName() != null) {
				restaurant1.setName(restaurant.getName());
			}
			if (restaurant.getAddress()!=null) {
				restaurant1.setAddress(restaurant.getAddress());
			}
			if (restaurant.getType()!=null) {
				restaurant1.setType(restaurant.getType());
			}
			return restaurant1;
		} else {
			restaurantRepo.save(restaurant);
			return restaurant;
		}
	}

	@Override
	public String deleteRestaurant(Long id) {
		if(id!=null) {
			restaurantRepo.deleteById(id);
			return "deleted successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public int getTotalRatings(Restaurant restaurant) {
		return 10;
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

	@Override
	public String getRestaurantNameById(Long id) {
		return restaurantRepo.findNameById(id);
	}

	@Override
	public String getRestaurantAddressById(Long id) {
		return restaurantRepo.findAddressById(id);
	}
	
}
