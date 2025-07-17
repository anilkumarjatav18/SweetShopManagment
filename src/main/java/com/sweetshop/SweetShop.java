package com.sweetshop;

import java.util.*;
import java.util.stream.Collectors;

public class SweetShop {
   // Map to store the Sweets
    private Map<Integer, Sweet> sweets;

    public SweetShop() {
        this.sweets = new HashMap<>();
    }

    public void addSweet(Sweet sweet) {
        if (sweets.containsKey(sweet.getId())) {
            //throw error if sweet id already exist
            throw new IllegalArgumentException("Sweet ID already exists");
        }
        sweets.put(sweet.getId(), sweet);
    }
    // method that return the  Number of sweets in the  store
    public List<Sweet> viewSweets() {
        return new ArrayList<>(sweets.values());
    }
    //Method to delete sweet from the store if conatins that sweet id
    public void deleteSweet(int id){
        if(!sweets.containsKey(id)){
            throw new IllegalArgumentException("sweet not found");
        }
        sweets.remove(id);
    }

}
