package org.example;

import java.util.HashMap;

public class GroceryStoreInventory {
    private HashMap<String, Integer> inventory = new HashMap<>();

    public void addProduct(String product, int quantity){
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
        System.out.println(product + " added with quantity: " + quantity + "\n");
    }

    public boolean checkProduct(String product){
        if (inventory.containsKey(product)) {
            System.out.println(product + " is in stock. Quantity: " + inventory.get(product) + "\n");
            return true;
        } else {
            System.out.println(product + " is not available.\n");
            return false;
        }
    }

    public void updateProduct(String product, int quantityChange){
        if(inventory.containsKey(product)){
            if(quantityChange < 0){
                System.out.println("Enter valid quantity");
            }else{
                inventory.put(product, quantityChange);
            }
        }else {
            System.out.println("Product does not exist");
        }
    }

    public void removeProduct(String product){
        if (inventory.containsKey(product)){
            inventory.remove(product);
            System.out.println("Product Removed\n");
        }
    }

    public void viewInventory(){
        System.out.println("Current Inventory:");
        for (String i : inventory.keySet()){
            System.out.println(i + " - " + inventory.get(i) + " pcs");
        }
        System.out.print("\n");
    }
}
