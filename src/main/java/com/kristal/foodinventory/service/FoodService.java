package com.kristal.foodinventory.service;

import java.util.List;

import com.kristal.foodinventory.model.Food;

// Service interface for Food operations
public interface FoodService {
    // Get all food items
    List<Food> getAllFood();

    // Get food item by ID
    Food getFoodItemById(String id);

    // Create a new food item
    void createFoodItem(Food food);

    // Delete a food item by ID
    void deleteFoodItem(String id);

    // Update a food item by ID
    Food updateFoodById(String id, Food food);
}
