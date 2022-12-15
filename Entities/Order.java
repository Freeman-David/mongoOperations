package Entities;

import com.fasterxml.jackson.annotation.*;

// An object that simulate Orders collection.
@Collection(collectionName = "Orders")
public class Order extends Entity {
    // Change to your collection data.
    public static final String PERSON_ID = "personId";
    public static final String PRODUCT_ID = "productId";
    public static final String AMOUNT = "amount";

    private int id;
    private int customerId;
    private int productId;
    private int amount;

    public Order(@JsonProperty("_id") int id, @JsonProperty("customerId") int customerId,
                 @JsonProperty("productId") int productId, @JsonProperty("amount") int amount) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getAmount() {
        return this.amount;
    }
}
