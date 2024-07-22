package com.ust.SpringReactive.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trip")
/**
 * This class represents a trip entity in the database.
 * It has fields for id, name, destination, duration, price, description, and status.
 * The @Document annotation is used to specify the collection name in the database.
 */
/**
 * This class represents a trip entity in the database.
 * It has fields for id, name, destination, duration, price, description, and status.
 * The @Document annotation is used to specify the collection name in the database.
 */
public class Trip {
    public String id;
    public String name;
    public String destination;
    public String duration;
    public double price;
    public int rating;
    public String description;
    public String status;
}
