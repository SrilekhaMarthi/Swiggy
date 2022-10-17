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
	private CartService CartService;
	private GResponse gResponse;
	
	public CartController(CartService CartService,GResponse gResponse) {
		this.CartService=CartService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/all")
	public GResponse getAllCarts() {
		gResponse.setData(CartService.getAllCarts());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getCartById(@PathVariable Long id) {
		gResponse.setData(CartService.getCartById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addCart(@Valid @RequestBody Cart Cart) {
		gResponse.setData(CartService.addCart(Cart));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateCart(@Valid @RequestBody Cart Cart,@PathVariable Long id) {
		gResponse.setData(CartService.updateCart(Cart, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteCart(@PathVariable Long id) {
		gResponse.setData(CartService.deleteCart(id));
		return gResponse;
	}
	
//	@GetMapping("/subTotal")
//	public GResponse getSubTotal(@RequestParam("userId") Long uid,@RequestParam("restaurantId") Long rid) {
//		//gResponse.setData(CartService.getSubTotal(uid,rid));
//	    //System.out.println("Total:"+gResponse);
//		return gResponse;
//	}
	
	
	
	
}
