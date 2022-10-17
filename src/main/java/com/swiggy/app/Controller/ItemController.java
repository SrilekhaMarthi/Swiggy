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
import com.swiggy.app.Service.ItemService;
import com.swiggy.app.model.Item;

@RestController
@RequestMapping("/api/item")
public class ItemController {
	private ItemService ItemService;
	private GResponse gResponse;
	
	public ItemController(ItemService ItemService,GResponse gResponse) {
		this.ItemService=ItemService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/allItems")
	public GResponse getAllItems() {
		gResponse.setData(ItemService.getAllItems());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getItemById(@PathVariable Long id) {
		gResponse.setData(ItemService.getItemById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addItem(@Valid @RequestBody Item Item) {
		gResponse.setData(ItemService.addItem(Item));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateItem(@Valid @RequestBody Item Item,@PathVariable Long id) {
		gResponse.setData(ItemService.updateItem(Item, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteItem(@PathVariable Long id) {
		gResponse.setData(ItemService.deleteItem(id));
		return gResponse;
	}
	
}
