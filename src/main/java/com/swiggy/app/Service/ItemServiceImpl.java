package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.ItemRepository;
import com.swiggy.app.model.Item;

@Service
public class ItemServiceImpl implements ItemService{

private ItemRepository itemRepo;
	
	public ItemServiceImpl(ItemRepository itemRepo) {
		this.itemRepo=itemRepo;
	}
	
	@Override
	public List<Item> getAllItems(){
		return itemRepo.findAll();
	}
	
	@Override
	public Item getItemById(Long id) {
		return itemRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}
	
	@Override
	public Item updateItem(Item item,Long id) {
		Boolean exists = itemRepo.existsById(id);
		if (exists) {
			return itemRepo.save(item);
		} 
		return null;
	}
	
	@Override
	public Item deleteItem(Long id) {
		itemRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Item rest = itemRepo.findById(id).get();
		 itemRepo.deleteById(id);
		 return rest;
	}
}
