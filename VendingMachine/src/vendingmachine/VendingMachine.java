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
    private int[] numDrinks;
    private String[] drinks;
    private static final double PRICE_OF_DRINK = 1.25;
    private static final int AMOUNT_FOR_RESTOCK = 10;
    private double mVal;
    private String prompt;
    private boolean canBuy;
    
    public VendingMachine (String[] drinks)
    {
        this.drinks = drinks;
        numDrinks = new int[drinks.length];
        
        for (int i = 0; i < numDrinks.length; i++)
            numDrinks[i] = 10;
        mVal = 0;
    }
    
    private int getDrinkIndex(String drink)
    {
        for (int i = 0; i < drinks.length; i++)
            if (drink.toLowerCase().equals(drinks[i].toLowerCase()))
                return i;
        
        return -1;
    }
    
    private boolean checkInventory (int drinkIndex)
    {
        return numDrinks[drinkIndex] > 0;
    }
    
    public String getInventory()
    {
        String complex = "";
        
        for (int i = 0; i < numDrinks.length; i++)
            complex += "There are " + numDrinks[i] + " " + drinks[i] + "s left in the vending machine. \n";
        
        return complex;
    }
    
    public void addMoney(double amt)
    {
        if (amt < 0)
            return;
        else
            mVal = amt;
    }
    
    public String refresh()
    {
        double temp = mVal;
        mVal = 0;
        return "Here is your money: $" + temp;
    }
    
    public void restock (int drinkIndex)
    {
        numDrinks[drinkIndex] = AMOUNT_FOR_RESTOCK;
    }
    
    public void purchase(int drinkIndex)
    {
        if (mVal >= 1.25)
        {
            numDrinks[drinkIndex]--;
            prompt = "Here is your " + drinks[drinkIndex] + ". Your change is $" + (mVal -= 1.25) + ". Have a nice day!";
        }
        else
        {
            prompt = "You do not have enough money to buy this drink. Please enter more money.";
        }
            
        
        if (!checkInventory(drinkIndex))
            restock(drinkIndex);
    }
    
    
}
