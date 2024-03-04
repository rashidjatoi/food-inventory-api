package com.kristal.foodinventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kristal.foodinventory.model.Food;
import com.kristal.foodinventory.repository.FoodItemRepository;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodItemRepository foodItemRepository;

    // Constructor injection for FoodItemRepository
    public FoodServiceImpl(final FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    @Override
    // Get all food items
    public List<Food> getAllFood() {
        return foodItemRepository.findAll();
    }

    @Override
    // Get food item by ID
    public Food getFoodItemById(String id) {
        Optional<Food> foundFood = foodItemRepository.findById(id);
        return foundFood.orElse(null);
    }

    @Override
    // Create a new food item
    public void createFoodItem(Food food) {
        foodItemRepository.save(food);
    }

    @Override
    // Delete a food item by ID
    public void deleteFoodItem(String id) {
        foodItemRepository.deleteById(id);
    }

    @Override
    // Update a food item by ID
    public Food updateFoodById(String id, Food food) {
        Optional<Food> foodFound = foodItemRepository.findById(id);
        if (foodFound.isPresent()) {
            Food existingFood = foodFound.get();
            existingFood.setId(food.getId());
            existingFood.setName(food.getName());
            existingFood.setQuantity(food.getQuantity());
            return foodItemRepository.save(existingFood);
        } else {
            // If food item not found for update, return null
            return null;
        }
    }

}
