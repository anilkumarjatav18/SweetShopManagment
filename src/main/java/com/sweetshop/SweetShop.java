package com.sweetshop;

import java.util.*;
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
    //method to return the list of the item search By name
    public List<Sweet> searchByName(String name){
        List<Sweet>result=new ArrayList<>(); // store the result
        for(Sweet sweet:sweets.values()) {
            if (sweet.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(sweet);
            }
        }
        return result;

    }
    public List<Sweet> searchByCategoty(String category){
        List<Sweet>resultByCategory=new ArrayList<>(); // store the result
        for(Sweet sweet:sweets.values()) {
            if (sweet.getCategory().toLowerCase().contains(category.toLowerCase())) {
                resultByCategory.add(sweet);
            }
        }
        return resultByCategory;

    }
    public List<Sweet> searchByPriceRange(double minimumPrice,double maximumPrice) {
        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets.values()) {
            if (sweet.getPrice()>minimumPrice && sweet.getPrice()<maximumPrice) {
                result.add(sweet);
            }
        }
        return result;
    }
    //purchase Sweet
    public void purchaseSweet(int id, int quantity) {
        Sweet sweet = sweets.get(id); // first get the sweet by id
        if (sweet == null) throw new IllegalArgumentException("Sweet not found");
        if (sweet.getQuantity() < quantity) throw new IllegalArgumentException("Not enough stock");
        sweet.setQuantity(sweet.getQuantity() - quantity);
    }
    //Restock the stock
    public void restockSweet(int id, int quantity) {
        Sweet sweet = sweets.get(id);
        if (sweet == null) {
            throw new IllegalArgumentException("Sweet not found");
        }
        sweet.setQuantity(sweet.getQuantity() + quantity);
    }

}
