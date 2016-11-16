package com.spr.baristamatic.drink;

import com.spr.baristamatic.ingredient.Ingredient;
import com.spr.baristamatic.inventory.Inventory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Represents a drink in baristamatic
 */
public interface Drink {

    /**
     * Name
     * @return {@linkplain String}
     */
    String getName();

    /**
     * In stock?
     * @param inventory current inventory
     * @return true|false
     */
    Boolean inStock(Inventory inventory);

    /**
     *
     * @return List of all {@linkplain Ingredient}s in lexicographic order by name
     */
    List<Ingredient> getIngredients();

    /**
     *
     * Sum of the prices of all ingredients
     *
     * @return {@linkplain BigDecimal} total
     */
    BigDecimal getTotal();
}
