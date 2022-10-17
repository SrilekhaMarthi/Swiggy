package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.OfferRepository;
import com.swiggy.app.model.Offer;

@Service
public class OfferServiceImpl implements OfferService{

private OfferRepository OfferRepo;
	
	public OfferServiceImpl(OfferRepository OfferRepo) {
		this.OfferRepo=OfferRepo;
	}
	
	@Override
	public List<Offer> getAllOffers(){
		return OfferRepo.findAll();
	}
	
	@Override
	public Offer getOfferById(Long id) {
		return OfferRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Offer addOffer(Offer Offer) {
		return OfferRepo.save(Offer);
	}
	
	@Override
	public Offer updateOffer(Offer offer,Long id) {
		Boolean exists = OfferRepo.existsById(id);
		if (exists) {
			return OfferRepo.save(offer);
		} 
		return null;
	}
	
	@Override
	public Offer deleteOffer(Long id) {
		OfferRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Offer rest = OfferRepo.findById(id).get();
		 OfferRepo.deleteById(id);
		 return rest;
	}
}
