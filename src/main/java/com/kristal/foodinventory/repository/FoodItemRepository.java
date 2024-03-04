package com.kristal.foodinventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kristal.foodinventory.model.Food;

// Repository interface for CRUD operations on Food items
public interface FoodItemRepository extends MongoRepository<Food, String> {

}
