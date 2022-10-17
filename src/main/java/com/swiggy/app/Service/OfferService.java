package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Offer;

public interface OfferService {

	List<Offer> getAllOffers();

	Offer getOfferById(Long id);

	Offer addOffer(Offer Offer);

	Offer updateOffer(Offer Offer, Long id);

	Offer deleteOffer(Long id);
}
