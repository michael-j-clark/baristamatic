package com.spr.baristamatic.ingredient;

import java.math.BigDecimal;

/**
 *  Represents ingredient in a drink
 */
public interface Ingredient {

    /**
     * Name
     * @return {@linkplain String} name of ingredient
     */
    String getName();

    /**
     * Get units
     * @return Number of units on hand
     */
    Integer getUnits();

    /**
     * Price
     * @return {@linkplain BigDecimal}
     */
    BigDecimal getPrice();

    /**
     *
     * Reset to MAX_UNITS
     */
    void restockUnits();

    /**
     * Use one(1) unit
     */
    void useOne();

    /**
     * Maximum number of units any Ingredient can have where quantity is full
     */
    Integer  MAX_UNITS = 10;
}
