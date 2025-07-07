package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GroceryStoreInventory groceryStoreInventory = new GroceryStoreInventory();
        Scanner scanner = new Scanner(System.in);

        int choice;

        while (true){
            System.out.println(
                    """
                    --- Grocery Inventory Menu ---
                    1. View Inventory
                    2. Add Product
                    3. Check Product
                    4. Update Stock
                    5. Remove Product
                    6. Exit
                    """
            );
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    groceryStoreInventory.viewInventory();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String addProduct = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int addQuantity = scanner.nextInt();
                    scanner.nextLine();
                    groceryStoreInventory.addProduct(addProduct, addQuantity);
                    break;
                case 3:
                    System.out.print("Enter product name to check: ");
                    String checkProduct = scanner.nextLine();
                    groceryStoreInventory.checkProduct(checkProduct);
                    break;
                case 4:
                    System.out.print("Enter product name to check: ");
                    String updateProduct = scanner.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    int updateQuantity = scanner.nextInt();
                    scanner.nextLine();
                    groceryStoreInventory.updateProduct(updateProduct, updateQuantity);
                    break;
                case 5:
                    System.out.print("Enter product name to remove: ");
                    String removeProduct = scanner.nextLine();
                    groceryStoreInventory.removeProduct(removeProduct);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter values 1 - 6");
            }
        }
    }
}