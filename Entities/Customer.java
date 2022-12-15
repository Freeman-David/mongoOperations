package Entities;

import com.fasterxml.jackson.annotation.*;

// An object that simulate Customers collection.
@Collection(collectionName = "Customers")
public class Customer extends Entity {
    // Change to your collection data.
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phoneNumber";

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public Customer
            (@JsonProperty("_id") int id, @JsonProperty("firstName") String firstName,
                 @JsonProperty("lastName") String lastName, @JsonProperty("address") String address,
             @JsonProperty("phoneNumber") String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
