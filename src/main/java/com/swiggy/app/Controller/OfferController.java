package com.swiggy.app.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;
import com.swiggy.app.Service.OfferService;
import com.swiggy.app.model.Offer;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
	private OfferService OfferService;
	private GResponse gResponse;
	
	public OfferController(OfferService OfferService,GResponse gResponse) {
		this.OfferService=OfferService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/all")
	public GResponse getAllOffers() {
		gResponse.setData(OfferService.getAllOffers());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getOfferById(@PathVariable Long id) {
		gResponse.setData(OfferService.getOfferById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addOffer(@Valid @RequestBody Offer Offer) {
		gResponse.setData(OfferService.addOffer(Offer));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateOffer(@Valid @RequestBody Offer Offer,@PathVariable Long id) {
		gResponse.setData(OfferService.updateOffer(Offer, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteOffer(@PathVariable Long id) {
		gResponse.setData(OfferService.deleteOffer(id));
		return gResponse;
	}
	
}
