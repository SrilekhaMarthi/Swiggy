package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Offer;

public interface OfferService {

	List<Offer> getAllOffers();

	Offer getOfferById(Long id);

	Offer addOffer(Offer offer);

	Offer updateOffer(Offer offer, Long id);

	Offer deleteOffer(Long id);
}
