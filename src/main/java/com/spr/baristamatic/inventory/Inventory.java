package com.spr.baristamatic.inventory;

import com.spr.baristamatic.ingredient.Ingredient;

import java.util.Map;

/**
 * The inventory of drink ingredients
 */
public interface Inventory {


    /**
     *
     * Reset all stock to maximum quantities
     */
     void restock();

    /**
     *
     * Get inventory
     * @return {@linkplain Map} where key=ingredient name.  Use {@linkplain java.util.TreeMap}
     *  implementation which orders by natural order of key which is useful for printing inventory
     *  in lexicographic order
     */
    Map<String, Ingredient> getIngredients();

}
