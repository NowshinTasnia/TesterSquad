package testersquad;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class TestProduct {

    @Test
    public void testGetId_Valid() {
        Product product = new Product(1, "Apple", 0.5, 10, "Fruit", LocalDate.of(2024, 6, 1));
        assertEquals(1, product.getId());
    }

    @Test
    public void testGetId_Different() {
        Product product = new Product(2, "Banana", 0.2, 15, "Fruit", LocalDate.of(2024, 6, 15));
        assertEquals(2, product.getId());
    }

    @Test
    public void testGetId_Boundary() {
        Product product = new Product(0, "Cherry", 0.3, 20, "Fruit", LocalDate.of(2024, 7, 1));
        assertEquals(0, product.getId());
    }

    @Test
    public void testGetName_Valid() {
        Product product = new Product(2, "Banana", 0.2, 15, "Fruit", LocalDate.of(2024, 6, 15));
        assertEquals("Banana", product.getName());
    }

    @Test
    public void testGetName_Different() {
        Product product = new Product(3, "Cherry", 0.3, 20, "Fruit", LocalDate.of(2024, 7, 1));
        assertEquals("Cherry", product.getName());
    }

    @Test
    public void testGetName_Empty() {
        Product product = new Product(4, "", 1.0, 25, "Fruit", LocalDate.of(2024, 8, 1));
        assertEquals("", product.getName());
    }

    @Test
    public void testGetPrice_Valid() {
        Product product = new Product(3, "Cherry", 0.3, 20, "Fruit", LocalDate.of(2024, 7, 1));
        assertEquals(0.3, product.getPrice(), 0.001);
    }

    @Test
    public void testGetPrice_Zero() {
        Product product = new Product(4, "Date", 0.0, 25, "Fruit", LocalDate.of(2024, 8, 1));
        assertEquals(0.0, product.getPrice(), 0.001);
    }

    @Test
    public void testGetPrice_High() {
        Product product = new Product(5, "Eggplant", 999.99, 5, "Vegetable", LocalDate.of(2024, 9, 1));
        assertEquals(999.99, product.getPrice(), 0.001);
    }

    @Test
    public void testGetQuantity_Valid() {
        Product product = new Product(4, "Date", 1.0, 25, "Fruit", LocalDate.of(2024, 8, 1));
        assertEquals(25, product.getQuantity());
    }

    @Test
    public void testGetQuantity_Zero() {
        Product product = new Product(6, "Fig", 2.0, 0, "Fruit", LocalDate.of(2024, 10, 1));
        assertEquals(0, product.getQuantity());
    }

    @Test
    public void testGetQuantity_Negative() {
        Product product = new Product(7, "Grape", 0.8, -5, "Fruit", LocalDate.of(2024, 11, 1));
        assertEquals(-5, product.getQuantity());
    }

    @Test
    public void testGetType_Valid() {
        Product product = new Product(5, "Eggplant", 1.5, 5, "Vegetable", LocalDate.of(2024, 9, 1));
        assertEquals("Vegetable", product.getType());
    }

    @Test
    public void testGetType_Different() {
        Product product = new Product(8, "Honeydew", 3.0, 12, "Fruit", LocalDate.of(2024, 12, 1));
        assertEquals("Fruit", product.getType());
    }

    @Test
    public void testGetType_Empty() {
        Product product = new Product(9, "Jackfruit", 1.2, 8, "", LocalDate.of(2023, 5, 1));
        assertEquals("", product.getType());
    }

    @Test
    public void testGetExpiryDate_Valid() {
        Product product = new Product(6, "Fig", 2.0, 30, "Fruit", LocalDate.of(2024, 10, 1));
        assertEquals(LocalDate.of(2024, 10, 1), product.getExpiryDate());
    }

    @Test
    public void testGetExpiryDate_Different() {
        Product product = new Product(7, "Grape", 0.8, 10, "Fruit", LocalDate.of(2024, 11, 1));
        assertEquals(LocalDate.of(2024, 11, 1), product.getExpiryDate());
    }

    @Test
    public void testGetExpiryDate_Past() {
        Product product = new Product(9, "Jackfruit", 1.2, 8, "Fruit", LocalDate.of(2023, 5, 1));
        assertEquals(LocalDate.of(2023, 5, 1), product.getExpiryDate());
    }

    @Test
    public void testSetPrice_Valid() {
        Product product = new Product(7, "Grape", 0.8, 10, "Fruit", LocalDate.of(2024, 11, 1));
        product.setPrice(0.9);
        assertEquals(0.9, product.getPrice(), 0.001);
    }

    @Test
    public void testSetPrice_Zero() {
        Product product = new Product(8, "Honeydew", 3.0, 12, "Fruit", LocalDate.of(2024, 12, 1));
        product.setPrice(0.0);
        assertEquals(0.0, product.getPrice(), 0.001);
    }

    @Test
    public void testSetPrice_Negative() {
        Product product = new Product(10, "Kiwi", 1.1, 7, "Fruit", LocalDate.of(2024, 5, 1));
        product.setPrice(-1.0);
        assertEquals(-1.0, product.getPrice(), 0.001);
    }

    @Test
    public void testSetQuantity_Valid() {
        Product product = new Product(8, "Honeydew", 3.0, 12, "Fruit", LocalDate.of(2024, 12, 1));
        product.setQuantity(14);
        assertEquals(14, product.getQuantity());
    }

    @Test
    public void testSetQuantity_Zero() {
        Product product = new Product(9, "Jackfruit", 1.2, 8, "Fruit", LocalDate.of(2023, 5, 1));
        product.setQuantity(0);
        assertEquals(0, product.getQuantity());
    }

    @Test
    public void testSetQuantity_Negative() {
        Product product = new Product(11, "Lemon", 0.5, 10, "Fruit", LocalDate.of(2024, 6, 1));
        product.setQuantity(-5);
        assertEquals(-5, product.getQuantity());
    }

    @Test
    public void testIsExpired_True() {
        Product product = new Product(9, "Jackfruit", 1.2, 8, "Fruit", LocalDate.of(2023, 5, 1));
        assertTrue(product.isExpired());
    }

    @Test
    public void testIsExpired_False() {
        Product product = new Product(10, "Kiwi", 1.1, 7, "Fruit", LocalDate.of(2024, 5, 1));
        assertTrue(product.isExpired());
    }

    @Test
    public void testIsExpired_Today() {
        Product product = new Product(12, "Mango", 1.0, 5, "Fruit", LocalDate.now());
        assertFalse(product.isExpired());
    }

    @Test
    public void testCalculateTotalValue_Valid() {
        Product product = new Product(11, "Lemon", 0.5, 10, "Fruit", LocalDate.of(2024, 6, 1));
        assertEquals(5.0, product.calculateTotalValue(), 0.001);
    }

    @Test
    public void testCalculateTotalValue_Different() {
        Product product = new Product(12, "Mango", 1.0, 5, "Fruit", LocalDate.of(2024, 7, 1));
        assertEquals(5.0, product.calculateTotalValue(), 0.001);
    }

    @Test
    public void testCalculateTotalValue_ZeroQuantity() {
        Product product = new Product(13, "Orange", 2.0, 0, "Fruit", LocalDate.of(2024, 8, 1));
        assertEquals(0.0, product.calculateTotalValue(), 0.001);
    }
}