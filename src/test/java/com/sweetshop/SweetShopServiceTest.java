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





}

