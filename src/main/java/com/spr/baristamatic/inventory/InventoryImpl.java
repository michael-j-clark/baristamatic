package com.spr.baristamatic.inventory;

import com.spr.baristamatic.ingredient.Ingredient;
import com.spr.baristamatic.inventory.Inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Baristamatic inventory.  All ingredients on hand
 */
public class InventoryImpl implements Inventory {


    public InventoryImpl(List<Ingredient> ingredients){

        for(Ingredient ingredient: ingredients){

            inventory.put(ingredient.getName(), ingredient);
        }
    }


    public Map<String, Ingredient> getIngredients() {
        return inventory;
    }

    /**
     * Current inventory
     */
    private Map<String,Ingredient> getInventory(){

        return inventory;
    }

    public void restock(){

        for (Ingredient ingredient : getInventory().values()) {
            ingredient.restockUnits();
        }
    }

    private final static Map<String,Ingredient> inventory = new TreeMap<>();
}
