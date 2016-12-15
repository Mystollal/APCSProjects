/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

/**
 *
 * @author anshulkamath
 */
public class VendingMachine 
{
    // Drink array: 0 - Water, 1 - Fanta, 2 - Coke, 3 - Sprite, 4 - Dr. Pepper
    private static int[] NUM_DRINKS = new int[5];
    private static final String[] DRINKS = {"Water", "Fanta", "Coke", "Sprite", "Dr. Pepper"};
    
    private int getDrinkIndex(String drink)
    {
        switch(drink.toLowerCase())
        {
            case "water":
                return 0;
            case "fanta":
                return 1;
            case "coke":
                return 2;
            case "sprite":
                return 3;
            case "dr. pepper":
                return 4;
            default:
                return -1;
        }
    }
    
    public String getInventory()
    {
        String complex = "";
        
        for (int i = 0; i < NUM_DRINKS.length; i++)
            complex += "There are " + NUM_DRINKS[i] + " " + DRINKS[i].toLowerCase() + "s left in the vending machine. \n";
        
        return complex;
    }
    
    
}
