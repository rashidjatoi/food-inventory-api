package com.kristal.foodinventory.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations for generating boilerplate code
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
// MongoDB Document annotation specifying the collection name
@Document(collection = "food-inventory")
public class Food {
    @Id
    private String id;
    private String name;
    private int quantity;
}
