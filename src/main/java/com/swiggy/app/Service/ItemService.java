package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Item;

public interface ItemService {

	List<Item> getAllItems();

	Item getItemById(Long id);

	Item addItem(Item item);

	Item updateItem(Item item, Long id);

	Item deleteItem(Long id);
}
