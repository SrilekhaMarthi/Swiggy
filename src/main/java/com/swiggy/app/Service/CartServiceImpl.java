package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.CartRepository;
import com.swiggy.app.model.Cart;

@Service
public class CartServiceImpl implements CartService {
	private CartRepository cartRepo;
	double sum;

	public CartServiceImpl(CartRepository cartRepo) {
		this.cartRepo = cartRepo;
	}

	@Override
	public List<Cart> getAllCarts() {
		List<Cart> carts=cartRepo.findAll();
		return carts;
	}

	@Override
	public Cart getCartById(Long id) {
		Cart cart=cartRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		cart.setSubTotal(getSubTotal(cart.getUserId(),cart.getRestaurantId()));
		return cart;

	}

	@Override
	public Cart addCart(Cart cart) {
		return cartRepo.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart, Long id) {
		Boolean exists = cartRepo.existsById(id);
		if (exists) {
			return cartRepo.save(cart);
		} 
		return null;
	}

	@Override
	public Cart deleteCart(Long id) {
		cartRepo.findById(id).orElseThrow(() -> new NoSuchElementException());
		Cart rest = cartRepo.findById(id).get();
		cartRepo.deleteById(id);
		return rest;
	}

	@Override
	public double getSubTotal(Long uid,Long rid) {
		sum=0;
		Cart cart=cartRepo.findByUserIdAndRestaurantId(uid, rid);
		cart.getItems().stream().forEach(item->{
			sum+=(item.getPrice())*(item.getQuantity());
		});
//		cart.forEach(c->c.getItems().forEach(item->{
//			sum+=(item.getPrice()*(item.getQuantity()));
//		}));
		
		return sum;
	}

	

	
}
