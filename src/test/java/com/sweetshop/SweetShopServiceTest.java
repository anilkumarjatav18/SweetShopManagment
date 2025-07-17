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
    @Test
    void testSearchByName(){
        shop.addSweet(new Sweet(1,"Laddoo","candy",10.0,30));
        List<Sweet>result=shop.searchByName("laddo");
        assertEquals(1,result.size());

    }
    //test  for searchBy category
    @Test
    void testSearchByCategory(){
        shop.addSweet(new Sweet(1,"Laddoo","candy",10.0,20));
        shop.addSweet(new Sweet(2,"Barfi","candy",10.0,20));
        shop.addSweet(new Sweet(3,"Jalebi","candy",10.0,20));
        //result store all the sweet of candy category
        List<Sweet>result=shop.searchByCategoty("candy");
        assertEquals(3,result.size());
    }
    @Test
    void testSearchByPriceRange(){
        shop.addSweet(new Sweet(1,"Laddoo","candy",10.0,20));
        shop.addSweet(new Sweet(2,"Barfi","candy",17.0,20));
        shop.addSweet(new Sweet(3,"Jalebi","candy",19.0,20));

        List<Sweet>result=shop.searchByPriceRange(10.0,20.0);
        assertEquals(2,result.size());
    }
    @Test
    void testPurchaseSweetSuccess(){
        shop.addSweet(new Sweet(1,"Laddoo","candy",10.0,20));
        shop.addSweet(new Sweet(2,"Barfi","candy",17.0,20));
        shop.addSweet(new Sweet(3,"Jalebi","candy",19.0,20));
        shop.purchaseSweet(1,10);
        assertEquals(10,shop.viewSweets().get(0).getQuantity());
    }


}

