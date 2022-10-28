package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

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
		Item item1 = itemRepo.findById(id).get();
		if (item1 != null) {
			if (item.getName() != null) {
				item1.setName(item.getName());
			}
			if (!Objects.isNull(item.getPrice())) {
				item1.setPrice(item.getPrice());
			}
			return item1;
		} else {
			itemRepo.save(item);
			return item;
		}
	}
	
	@Override
	public String deleteItem(Long id) {
		if(id!=null) {
			itemRepo.deleteById(id);
			return "deleted successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
	}
}
