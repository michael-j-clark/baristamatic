package com.spr.baristamatic.drink;

import com.spr.baristamatic.ingredient.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import com.spr.baristamatic.drink.Drink;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:DrinkTest-context.xml"})
public class DrinkTest {

    /**
     *
     *Test that wiring worked.
     * Test property of Drink coffee object
     */
    @Test
    public void testWiring(){

        if(!"Coffee".matches(coffee.getName())){
            fail("Name does not match expected value");
        }
    }

    /**
     *
     * Test Coffee total
     *  3 Coffee + 1 Cream + 1 Sugar = $2.75
     */
    @Test
    public void testCoffeeTotal(){

        assertEquals("Total price of Coffee is wrong", new BigDecimal("2.75"), coffee.getTotal());
    }

    @Resource(name = "coffee")
    private Drink coffee;
}
