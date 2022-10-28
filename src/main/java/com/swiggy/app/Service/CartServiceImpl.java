package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.CartRepository;
import com.swiggy.app.Repository.OfferRepository;
import com.swiggy.app.model.Cart;
import com.swiggy.app.model.Offer;

@Service
public class CartServiceImpl implements CartService {
	private CartRepository cartRepo;
	private OfferRepository offerRepo;
	double sum;

	public CartServiceImpl(CartRepository cartRepo, OfferRepository offerRepo) {
		this.cartRepo = cartRepo;
		this.offerRepo = offerRepo;
	}

	@Override
	public List<Cart> getAllCarts() {
		List<Cart> carts = cartRepo.findAll();
		return carts;
	}

	@Override
	public Cart getCartById(Long id) {
		Cart cart = cartRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		cart.setSubTotal(getSubTotal(cart.getUserId(), cart.getRestaurantId()));
		return cart;

	}

	@Override
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart, Long id) {
		Cart cart1 = cartRepo.findById(id).get();
		if (cart1 != null) {
			if (cart.getItem() != null) {
				cart1.setItem(cart.getItem());
			}
			return cart1;
		} else {
			cartRepo.save(cart);
			return cart;
		}

	}

	@Override
	public String deleteCart(Long id) {
		if(id!=null) {
			cartRepo.deleteById(id);
			return "deleted successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
		
	}

	@Override
	public double getSubTotal(Long uid, Long rid) {
		sum = 0;
		Cart cart = cartRepo.findByUserIdAndRestaurantId(uid, rid);
		cart.getItems().stream().forEach(item -> {
			sum += (item.getPrice()) * (item.getQuantity());
		});
		System.out.println("sum:" + sum);
		if (sum > 150) {
			System.out.println("trynew");
			calculateDiscount("TRYNEW");
		} else if (sum > 479) {
			System.out.println("jumbo");
			calculateDiscount("JUMBO");
		}
		return sum;
	}

	public double calculateDiscount(String couponCode) {
		if (!Objects.isNull(couponCode)) {
			Offer offer = offerRepo.findOfferByCouponCode(couponCode);
			if (!Objects.isNull(offer.getMinItemTotal())) {
				double maxDiscount = 0.8 * offer.getMinItemTotal();
				if (sum > offer.getMinItemTotal()) {
					if (offer.getCouponCode().equals(couponCode)) {
						if (sum * offer.getPercentage() > maxDiscount) {
							sum -= maxDiscount;
						} else {
							sum = sum - sum * offer.getPercentage();
						}
					}
				}
			}
		}
		return sum;
		
	}

}
