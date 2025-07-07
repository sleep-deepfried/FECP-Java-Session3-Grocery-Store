package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroceryStoreInventory groceryStoreInventory = new GroceryStoreInventory();
        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("""
                    --- Grocery Inventory Menu ---
                    1. View Inventory
                    2. Add Product
                    3. Check Product
                    4. Update Stock
                    5. Remove Product
                    6. Exit
                    """);
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> {
                    Map<String, Integer> inventory = groceryStoreInventory.viewInventory();
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.\n");
                    } else {
                        System.out.println("Current Inventory:");
                        inventory.forEach((product, qty) ->
                                System.out.println(product + " - " + qty + " pcs"));
                        System.out.println();
                    }
                }
                case 2 -> {
                    System.out.print("Enter product name: ");
                    String addProduct = scanner.nextLine().trim();
                    System.out.print("Enter product quantity: ");
                    int addQuantity = scanner.nextInt();
                    scanner.nextLine();
                    groceryStoreInventory.addProduct(addProduct, addQuantity);
                    System.out.println(addProduct + " added with quantity: " + addQuantity + "\n");
                }
                case 3 -> {
                    System.out.print("Enter product name to check: ");
                    String checkProduct = scanner.nextLine().trim();
                    int qty = groceryStoreInventory.checkProduct(checkProduct);
                    if (qty == -1) {
                        System.out.println(checkProduct + " is not available.\n");
                    } else {
                        System.out.println(checkProduct + " is in stock. Quantity: " + qty + "\n");
                    }
                }
                case 4 -> {
                    System.out.print("Enter product name to update: ");
                    String updateProduct = scanner.nextLine().trim();
                    System.out.print("Enter new stock quantity: ");
                    int updateQuantity = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = groceryStoreInventory.updateProduct(updateProduct, updateQuantity);
                    if (updated) {
                        System.out.println(updateProduct + " quantity overwritten to: " + updateQuantity + "\n");
                    } else {
                        System.out.println("Failed to update. Product may not exist or quantity is invalid.\n");
                    }
                }
                case 5 -> {
                    System.out.print("Enter product name to remove: ");
                    String removeProduct = scanner.nextLine().trim();
                    Map<String, Integer> updatedInventory = groceryStoreInventory.removeProduct(removeProduct);
                    if (!updatedInventory.containsKey(removeProduct)) {
                        System.out.println(removeProduct + " has been removed (if it existed).\n");
                    }
                }
                case 6 -> {
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Enter a number between 1 - 6.\n");
            }
        }
    }
}
