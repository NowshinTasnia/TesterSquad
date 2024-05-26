package testersquad;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestShoppingCart {
    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Product 1", 10.0);
        product2 = new Product("Product 2", 20.0);
    }

    @Test
    public void testAddItem() {
        cart.addItem(product1, 2);
        assertEquals(2, cart.getTotalQuantity());
    }

    @Test
    public void testAddItemMultipleTimes() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);
        assertEquals(3, cart.getTotalQuantity());
    }

    @Test
    public void testAddItemZeroQuantity() {
        cart.addItem(product1, 0);
        assertEquals(0, cart.getTotalQuantity());
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(product1, 2);
        cart.removeItem(product1, 1);
        assertEquals(1, cart.getTotalQuantity());
    }

    @Test
    public void testRemoveItemNonExistingProduct() {
        cart.addItem(product1, 2);
        cart.removeItem(product2, 1); 
        assertEquals(2, cart.getTotalQuantity()); 
    }

    @Test
    public void testRemoveItemZeroQuantity() {
        cart.addItem(product1, 2);
        cart.removeItem(product1, 0);
        assertEquals(2, cart.getTotalQuantity());
    }

    @Test
    public void testGetItems() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);
        assertEquals(2, cart.getItems().size());
    }

    @Test
    public void testCalculateTotalPrice() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);
        assertEquals(40.0, cart.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testCalculateTotalPriceWithDiscount() {
        cart.addItem(product1, 2);
        cart.applyDiscount(10.0); // 10% discount
        assertEquals(18.0, cart.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testClear() {
        cart.addItem(product1, 2);
        cart.clear();
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        cart.addItem(product1, 2);
        assertFalse(cart.isEmpty());
    }

    @Test
    public void testGetTotalQuantity() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 1);
        assertEquals(3, cart.getTotalQuantity());
    }

    @Test
    public void testContainsProduct() {
        cart.addItem(product1, 2);
        assertTrue(cart.containsProduct(product1));
    }

    @Test
    public void testDoesNotContainProduct() {
        assertFalse(cart.containsProduct(product1));
    }

    @Test
    public void testGetItemsAboveThreshold() {
        cart.addItem(product1, 2);
        cart.addItem(product2, 3);
        assertEquals(1, cart.getItemsAboveThreshold(2).size());
    }

    @Test
    public void testUpdateQuantity() {
        cart.addItem(product1, 2);
        cart.updateQuantity(product1, 3);
        assertEquals(3, cart.getTotalQuantity());
    }

    @Test
    public void testUpdateQuantityToZero() {
        cart.addItem(product1, 2);
        cart.updateQuantity(product1, 0);
        assertEquals(0, cart.getTotalQuantity());
    }

    @Test
    public void testUpdateQuantityNonExistingProduct() {
        cart.addItem(product1, 2);
        cart.updateQuantity(product2, 3); 
    }
}
