package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
class GroceryStoreInventoryTest {
    private GroceryStoreInventory inventory;

    @BeforeEach
    void setup(){
        inventory = new GroceryStoreInventory();
        inventory.addProduct("Milk", 20);
        inventory.addProduct("Bread", 15);
        inventory.addProduct("Eggs", 10);
    }

    @Test
    void testAddNewProduct(){
        inventory.addProduct("Banana", 30);
        assertEquals(30, inventory.checkProduct("Banana"));
    }

    @Test
    void testAddZeroQuantity(){
        inventory.addProduct("Mango", 0);
        assertEquals(0, inventory.checkProduct("Mango"));
    }

    @Test
    void testAddExistingProduct(){
        inventory.addProduct("Milk", 30);
        assertEquals(50, inventory.checkProduct("Milk"));
    }

    @Test
    void testExistingProduct(){
        int qty = inventory.checkProduct("Milk");
        assertNotEquals(-1, qty);
    }

    @Test
    void testNotExistingProduct(){
        int qty = inventory.checkProduct("Ice Cream");
        assertEquals(-1, qty);
    }

    @Test
    void testUpdateExistingProduct(){
        assertTrue(inventory.updateProduct("Bread", 25));
    }

    @Test
    void testUpdateExistingProductWithNegativeQuantity(){
        assertFalse(inventory.updateProduct("Bread", -1));
    }

    @Test
    void testUpdateNotExistingProduct(){
        assertFalse(inventory.updateProduct("Tofu",20));
    }

    @Test
    void testRemoveExistingProduct(){
        assertTrue(inventory.removeProduct("Eggs"));
    }

    @Test
    void testRemoveNotExistingProduct(){
        assertFalse(inventory.removeProduct("Pizza"));
    }

    @Test
    void testViewInventory(){
        assertFalse(inventory.viewInventory().isEmpty());
    }


}