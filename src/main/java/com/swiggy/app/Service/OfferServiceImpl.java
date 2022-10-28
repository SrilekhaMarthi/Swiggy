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
		Offer offer1 = offerRepo.findById(id).get();
		if (offer1 != null) {
			if (offer.getCouponCode()!= null) {
				offer1.setCouponCode(offer.getCouponCode());
			}
			return offer1;
		} else {
			offerRepo.save(offer);
			return offer;
		}
	}
	
	@Override
	public String deleteOffer(Long id) {
		if(id!=null) {
			offerRepo.deleteById(id);
			return "deleted successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public Offer findOfferByCouponCode(String couponCode) {
		return offerRepo.findOfferByCouponCode(couponCode);
	}
	
	
}
