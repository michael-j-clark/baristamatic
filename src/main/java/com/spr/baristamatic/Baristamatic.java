package com.spr.baristamatic;

import com.spr.baristamatic.drink.Drink;
import com.spr.baristamatic.ingredient.Ingredient;
import com.spr.baristamatic.inventory.Inventory;

import java.util.Map;

/**
 * Baristamatic coffee dispenser
 */
public interface Baristamatic {

    /**
     *
     * Get immutable {@linkplain Inventory}
     * @return Inventory
     */
    Inventory getInventory();

    /**
     * Drink menu
     * @return {@linkplain java.util.TreeMap}&lt;{@linkplain String},{@linkplain Drink}&gt;
     */
    Map<String,Drink> getMenu();

    /**
     * Dispense drink
     * @param drinkIndex index of drink
     */
    void dispense(Integer drinkIndex);


    /**
     *
     * Print drinks
     *
     * Menu:
     * <drink number>,<drink name>,<cost>,<in-stock> ...
     * <drink number>,<drink name>,<cost>,<in-stock>
     */
    default void printMenu(){

        int drinkIndex=1;
        System.out.println("Menu:");
        for(Drink drink: getMenu().values()){

            System.out.println((drinkIndex++)+","+ drink.getName()+",$"+drink.getTotal()+","+drink.inStock(getInventory()));
        }
    }

    default void printOutOfStock(Drink drink){

        System.out.println("Out of stock: "+drink.getName());
    }

    /**
     * Pring "Dispensing: %lt;drink name&gt;"
     * @param drink
     */
    default void printDispensing(Drink drink){

        System.out.println("Dispensing: "+drink.getName());
    }

    /**
     *
     * Print inventory
     *
     * Inventory:
     * <ingredient name>,<quantity in inventory>
     * ...
     * <ingredient name>,<quantity in inventory>
     */
    default void printInventory(){

        System.out.println("Inventory:");
        for(Ingredient ingredient: getInventory().getIngredients().values()){

            System.out.println(ingredient.getName()+","+ingredient.getUnits());
        }
    }

    /**
     *
     * Restock inventory
     */
    void restock();

}
