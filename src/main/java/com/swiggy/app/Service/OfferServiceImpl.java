package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.OfferRepository;
import com.swiggy.app.model.Offer;

@Service
public class OfferServiceImpl implements OfferService{

private OfferRepository offerRepo;
	
	public OfferServiceImpl(OfferRepository offerRepo) {
		this.offerRepo=offerRepo;
	}
	
	@Override
	public List<Offer> getAllOffers(){
		return offerRepo.findAll();
	}
	
	@Override
	public Offer getOfferById(Long id) {
		return offerRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Offer addOffer(Offer offer) {
		return offerRepo.save(offer);
	}
	
	@Override
	public Offer updateOffer(Offer offer,Long id) {
		Boolean exists = offerRepo.existsById(id);
		if (exists) {
			return offerRepo.save(offer);
		} 
		return null;
	}
	
	@Override
	public Offer deleteOffer(Long id) {
		offerRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Offer rest = offerRepo.findById(id).get();
		offerRepo.deleteById(id);
		 return rest;
	}
}
