import Entities.Order;
import MongoOperation.MongoOperation;

import java.io.IOException;
import java.util.List;

import static MongoOperation.Query.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Example of usage.
        List<Order> documents = MongoOperation.find(Order.class)
                .filter(and(lte(Order.AMOUNT, 100), gt(Order.AMOUNT, 10))).many();

        System.out.println(documents.get(0).getCustomerId());
    }
}
