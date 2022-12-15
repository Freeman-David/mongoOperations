package Entities;

import com.fasterxml.jackson.annotation.*;

// An object that simulate Products collection.
@Collection(collectionName = "Products")
public class Product extends Entity {
    // Change to your collection data.
    public static final String NAME = "name";
    public static final String PRICE = "price";

    private int id;
    private String name;
    private int price;

    public Product(@JsonProperty("_id") int id, @JsonProperty("name") String name,
                 @JsonProperty("price") int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
