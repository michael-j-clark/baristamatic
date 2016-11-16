package com.spr.baristamatic;

import com.spr.baristamatic.drink.Drink;
import com.spr.baristamatic.ingredient.Ingredient;
import com.spr.baristamatic.inventory.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Scanner;

/**
 * Baristamatic coffee dispenser
 */
public class BaristamaticImpl implements Baristamatic{

    public BaristamaticImpl(Inventory inventory,Map<String,Drink> menu){

        this.inventory = inventory;
        this.menu=menu;
    }

    public void restock(){

        getInventory().restock();
    }

    public Inventory getInventory(){

        return this.inventory;
    }

    public Map<String,Drink> getMenu(){

        return menu;
    }

    public void dispense(Integer drinkIndex){

        Drink drink = (Drink)getMenu().values().toArray()[drinkIndex - 1];

        if(drink.inStock(getInventory())){

            printDispensing(drink);
            for(Ingredient ingredient: drink.getIngredients()){

                ((Ingredient) inventory.getIngredients().get(ingredient.getName())).useOne();
            }

        }else{

            printOutOfStock(drink);
        }
    }

    /**
     *
     * Your solution should read from the standard input stream, one command per line. No prompts or other extraneous
     * user messages should be displayed.
     * Blank input lines should be ignored.
     * Each valid command consists of a single character, as follows:
     • 'R' or 'r' - restock the inventory and redisplay the menu
     • 'Q' or 'q' - quit the application
     • [1-6] - order the drink with the corresponding number in the menu
     * If the user enters an invalid command, then the program should display a single-line message with the following
     * format:
     * Invalid selection: <characters that were entered>
     * If the user selects a valid drink number, and the machine has sufficient ingredients on hand to make the drink,
     * then the program should display a single-line message with the following format:
     * Dispensing: <drink name>
     * On the other hand, if the drink order cannot be completed, then the program should display a single-line message
     * with the following format:
     * Out of stock: <drink name>
     * The inventory and menu (see next section) should be displayed immediately, one after the other, following any
     * applicable message.
     * @param args
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Baristamatic-context.xml");

        Baristamatic baristamatic = (Baristamatic)context.getBean("baristamatic");

        baristamatic.printInventory();
        baristamatic.printMenu();

        String s = "";

        while((s = sc.nextLine()) != null ){

            if(s.trim().equals("")) {
                continue;
            }else if(s.trim().matches("[1-6]")){
                baristamatic.dispense(Integer.parseInt(s.trim()));
                baristamatic.printInventory();
                baristamatic.printMenu();
            }else if (s.trim().equalsIgnoreCase("R")){//restock
                baristamatic.restock();
                baristamatic.printInventory();
                baristamatic.printMenu();
            }else if (s.trim().equalsIgnoreCase("Q")) {//quit

                break;
            }else{

                System.out.println("Invalid selection: "+s);
            }
        }
    }

    /**
     * Inventory of ingredients
     */
    private final Inventory inventory;
    /**
     * Menu where key=&lt;drink name&gt; and value={@linkplain Drink}
     */
    private final Map<String,Drink> menu;
}
