package com.spr.baristamatic.inventory;

import com.spr.baristamatic.ingredient.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:InventoryTest-context.xml"})

/**
 * Inventory tests
 */
public class InventoryTest {

    @Before
    public void setUp(){

        inventory.restock();
    }

    @Test
    public void testUseStock(){
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();

        assertEquals("Did not equal expect amount (7)" , new Integer(7) ,(((Ingredient) inventory.getIngredients().get("Coffee")).getUnits()));
    }

    @Test
    public void testRestock(){
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();
        ((Ingredient) inventory.getIngredients().get("Coffee")).useOne();

        inventory.restock();

        assertEquals("Did not equal expect amount (MAX_UNITS)" , Ingredient.MAX_UNITS , ((Ingredient) inventory.getIngredients().get("Coffee")).getUnits());
    }

    @Resource(name="inventory")
    Inventory inventory;
}
