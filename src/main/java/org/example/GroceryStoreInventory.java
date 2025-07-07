package org.example;

import java.util.*;

public class GroceryStoreInventory {
    private final HashMap<String, Integer> inventory = new HashMap<>();

    public Map<String, Integer> addProduct(String product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
        return inventory;
    }

    public int checkProduct(String product) {
        return inventory.getOrDefault(product, -1);
    }

    public boolean updateProduct(String product, int newQuantity) {
        if (inventory.containsKey(product)) {
            if (newQuantity < 0) return false;
            inventory.put(product, newQuantity);
            return true;
        }
        return false;
    }
    public Map<String, Integer> removeProduct(String product) {
        inventory.remove(product);
        return inventory;
    }

    public Map<String, Integer> viewInventory() {
        return new HashMap<>(inventory);
    }
}
