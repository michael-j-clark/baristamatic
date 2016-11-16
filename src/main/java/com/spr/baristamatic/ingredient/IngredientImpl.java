package com.spr.baristamatic.ingredient;

import java.math.BigDecimal;

/**
 * Created by michaelclark on 11/13/16.
 */
public class IngredientImpl implements Ingredient
{

    public IngredientImpl(String name, BigDecimal price) {
        this.name = name;
        this.units = MAX_UNITS;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setUnits(Integer units){
        this.units=units;
    }

    public Integer getUnits() {
        return units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void restockUnits(){

        setUnits(MAX_UNITS);
    }

    public void useOne(){

        this.units--;
    }

    /**
     * Name of {@linkplain Ingredient}
     */
    private final String name;

    /**
     * Ingredients in inventory
     */
    private  Integer units;

    /**
     * {@linkplain BigDecimal} price
     */
    private final BigDecimal price;
}
