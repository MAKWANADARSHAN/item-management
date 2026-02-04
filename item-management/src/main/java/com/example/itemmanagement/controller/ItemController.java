package com.example.itemmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.itemmanagement.model.Item;
import com.example.itemmanagement.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	// Add new item
	@PostMapping
	public ResponseEntity<?> addItem(@RequestBody Item item) {

		if (item.getName() == null || item.getName().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item name is required");
		}

		if (item.getDescription() == null || item.getDescription().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Item description is required");
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(itemService.addItem(item));
	}

	// Get item by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getItem(@PathVariable int id) {

		Item item = itemService.getItemById(id);

		if (item == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found");
		}

		return ResponseEntity.ok(item);
	}
}
