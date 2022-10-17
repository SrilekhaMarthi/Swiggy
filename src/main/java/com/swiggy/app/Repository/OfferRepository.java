package com.swiggy.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swiggy.app.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long>{

}
