package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.ItemRepository;
import com.swiggy.app.model.Item;

@Service
public class ItemServiceImpl implements ItemService{

private ItemRepository ItemRepo;
	
	public ItemServiceImpl(ItemRepository ItemRepo) {
		this.ItemRepo=ItemRepo;
	}
	
	@Override
	public List<Item> getAllItems(){
		return ItemRepo.findAll();
	}
	
	@Override
	public Item getItemById(Long id) {
		return ItemRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Item addItem(Item Item) {
		return ItemRepo.save(Item);
	}
	
	@Override
	public Item updateItem(Item item,Long id) {
		Boolean exists = ItemRepo.existsById(id);
		if (exists) {
			return ItemRepo.save(item);
		} 
		return null;
	}
	
	@Override
	public Item deleteItem(Long id) {
		ItemRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Item rest = ItemRepo.findById(id).get();
		 ItemRepo.deleteById(id);
		 return rest;
	}
}
