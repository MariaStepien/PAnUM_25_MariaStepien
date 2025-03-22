package com.example.cafeapp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {

    private static Order instance;
    private Map<String, OrderItem> items;

    private Order() {
        items = new HashMap<>();
    }

    public static synchronized Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public static class OrderItem implements Serializable {
        int quantity;
        double price;

        public OrderItem(int quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }

        public double getTotalPrice() {
            return quantity * price;
        }

    }

    public void addItem(String itemName, int quantity, double price) {
        if (items.containsKey(itemName)) {
            OrderItem existingItem = items.get(itemName);
            existingItem.quantity += quantity;
        } else {
            items.put(itemName, new OrderItem(quantity, price));
        }
    }

    public float getTotalOrderPrice() {
        float total = 0.0f;
        for (OrderItem item : items.values()) {
            total += (float) item.getTotalPrice();
        }
        return total;
    }

    public Map<String, OrderItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void clearOrder() {
        items.clear();
    }

}
