package com.example.itemmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.itemmanagement.model.Item;

@Service
public class ItemService {

	private List<Item> items = new ArrayList<>();

	public Item addItem(Item item) {
		items.add(item);
		return item;
	}

	public Item getItemById(int id) {
		return items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
	}
}
