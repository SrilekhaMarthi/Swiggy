package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Cart;

public interface CartService {

	List<Cart> getAllCarts();

	Cart getCartById(Long id);

	Cart addCart(Cart Cart);

	Cart updateCart(Cart Cart, Long id);

	Cart deleteCart(Long id);

	double getSubTotal(Long uid, Long rid);
}
