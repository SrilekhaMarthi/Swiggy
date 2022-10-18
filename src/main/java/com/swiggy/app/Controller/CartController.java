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
import com.swiggy.app.Service.CartService;
import com.swiggy.app.model.Cart;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	private CartService cartService;
	private GResponse gResponse;
	
	public CartController(CartService cartService,GResponse gResponse) {
		this.cartService=cartService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/all")
	public GResponse getAllCarts() {
		gResponse.setData(cartService.getAllCarts());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getCartById(@PathVariable Long id) {
		gResponse.setData(cartService.getCartById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addCart(@Valid @RequestBody Cart cart) {
		gResponse.setData(cartService.addCart(cart));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateCart(@Valid @RequestBody Cart cart,@PathVariable Long id) {
		gResponse.setData(cartService.updateCart(cart, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteCart(@PathVariable Long id) {
		gResponse.setData(cartService.deleteCart(id));
		return gResponse;
	}
	
//	@GetMapping("/subTotal")
//	public GResponse getSubTotal(@RequestParam("userId") Long uid,@RequestParam("restaurantId") Long rid) {
//		//gResponse.setData(CartService.getSubTotal(uid,rid));
//	    //System.out.println("Total:"+gResponse);
//		return gResponse;
//	}
	
	
	
	
}
