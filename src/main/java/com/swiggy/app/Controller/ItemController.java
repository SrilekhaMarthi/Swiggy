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
	private ItemService itemService;
	private GResponse gResponse;
	
	public ItemController(ItemService itemService,GResponse gResponse) {
		this.itemService=itemService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/allItems")
	public GResponse getAllItems() {
		gResponse.setData(itemService.getAllItems());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getItemById(@PathVariable Long id) {
		gResponse.setData(itemService.getItemById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addItem(@Valid @RequestBody Item item) {
		gResponse.setData(itemService.addItem(item));
		return gResponse;
	}
	
	@PutMapping("/{id}")
	public GResponse updateItem(@Valid @RequestBody Item item,@PathVariable Long id) {
		gResponse.setData(itemService.updateItem(item, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteItem(@PathVariable Long id) {
		gResponse.setData(itemService.deleteItem(id));
		return gResponse;
	}
	
}
