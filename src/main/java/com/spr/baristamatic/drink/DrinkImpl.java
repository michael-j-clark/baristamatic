package com.spr.baristamatic.drink;

import com.spr.baristamatic.ingredient.Ingredient;
import com.spr.baristamatic.inventory.Inventory;
import jdk.nashorn.internal.runtime.options.Option;

import java.math.BigDecimal;
import java.util.*;

/**
 * Drink concretion
 */
public class DrinkImpl implements Drink{

    public DrinkImpl(String name, List<Ingredient> ingredients){

        this.name=name;
        this.ingredients=ingredients;
        total = ingredients.stream().map(Ingredient::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        total.setScale(2,BigDecimal.ROUND_HALF_EVEN);

    }

    public Boolean inStock(Inventory inventory){

        Map<String,Integer> ingredientCount = new HashMap<>();


        for(Ingredient ingredient: this.getIngredients()){

            Integer count = (ingredientCount.get(ingredient.getName())==null) ? 0 : (ingredientCount.get(ingredient.getName()));

            ingredientCount.put(ingredient.getName(), ++count);
        }

        for(Map.Entry<String, Integer> ic: ingredientCount.entrySet()){

            String name = ic.getKey();
            Integer count = ic.getValue();

            Ingredient ingredient = inventory.getIngredients().get(name);

            if(count> ingredient.getUnits()){
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }



    public BigDecimal getTotal(){

        return total;
    }

    private final String name;
    private final List<Ingredient> ingredients;
    private final BigDecimal total;
}
