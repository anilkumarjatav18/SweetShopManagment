package com.sweetshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SweetShopServiceTest{

    private SweetShop shop;

    @BeforeEach
    void setUp() {
        shop = new SweetShop();
    }
// test to check the addSweet
    @Test
    void testAddSweet() {
        Sweet sweet = new Sweet(1, "Ladoo", "Candy", 10.0, 50);
        Sweet sweet1 = new Sweet(2, "Barfi", "Candy", 10.0, 50);

        shop.addSweet(sweet);
        shop.addSweet(sweet1);
        // expected that  number of items should be to
        assertEquals(2, shop.viewSweets().size());
    }
    @Test
    void testDeleteSweet() {
        Sweet sweet = new Sweet(1, "Ladoo", "Candy", 10.0, 50);
        shop.addSweet(sweet);
        shop.deleteSweet(1);
        assertEquals(0, shop.viewSweets().size());
    }
    @Test
    void testViewSweets_whenSweetsAdded_shouldReturnAllSweets() {
        SweetShop shop = new SweetShop();
        Sweet sweet1 = new Sweet(1, "Ladoo", "Candy", 10.0, 50);
        Sweet sweet2 = new Sweet(2, "Barfi", "Pastry", 20.0, 30);

        shop.addSweet(sweet1);
        shop.addSweet(sweet2);

        List<Sweet> sweets = shop.viewSweets();

        assertEquals(2, sweets.size(), "Sweets list should contain 2 sweets");
        assertTrue(sweets.contains(sweet1), "Sweets list should contain sweet1");
        assertTrue(sweets.contains(sweet2), "Sweets list should contain sweet2");
    }






}

