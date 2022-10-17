package com.swiggy.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swiggy.app.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
	
	@Query("SELECT res from Restaurant res where res.avgRating>?1")
	List<Restaurant> findByRating(double avgRating);
	
	@Query("SELECT res from Restaurant res where res.type=?1")
	List<Restaurant> findByType(String type);
}
