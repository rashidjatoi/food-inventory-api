package com.kristal.foodinventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kristal.foodinventory.model.Food;
import com.kristal.foodinventory.service.FoodServiceImpl;

@RestController
@RequestMapping(name = "/api/food") // Base mapping for food-related endpoints
public class FoodController {

    private final FoodServiceImpl foodService;

    // Constructor injection for FoodServiceImpl
    public FoodController(FoodServiceImpl foodService) {
        this.foodService = foodService;
    }

    // Get all food items
    @GetMapping
    public ResponseEntity<List<Food>> getAllFoodItem(@RequestBody Food food) {
        List<Food> foundFood = foodService.getAllFood();
        if (!foundFood.isEmpty()) {
            return new ResponseEntity<>(foundFood, HttpStatus.OK);
        }
        // If no food items found, return OK with an empty list
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Get food item by ID
    @GetMapping(name = "/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable String id) {
        Food foundFood = foodService.getFoodItemById(id);
        if (foundFood != null) {
            return new ResponseEntity<>(foundFood, HttpStatus.OK);
        } else {
            // If food item not found, return NOT_FOUND
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new food item
    @PostMapping
    public ResponseEntity<?> createFoodItem(@RequestBody Food food) {
        foodService.createFoodItem(food);
        // Return the created food item with OK status
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    // Delete a food item by ID
    @DeleteMapping(name = "/{id}")
    public ResponseEntity<?> deleteFoodById(@PathVariable String id) {
        foodService.deleteFoodItem(id);
        // Return OK status after successful deletion
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Update a food item by ID
    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodById(@PathVariable String id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFoodById(id, food);
        if (updatedFood != null) {
            // If food item updated successfully, return the updated food item with OK
            // status
            return ResponseEntity.ok(updatedFood);
        } else {
            // If food item not found for update, return NOT_FOUND
            return ResponseEntity.notFound().build();
        }
    }

}
