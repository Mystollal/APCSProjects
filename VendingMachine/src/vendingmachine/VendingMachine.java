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
    private Item[] items;
    private final int AMOUNT_FOR_RESTOCK;
    private double mVal;
    private String prompt;
    private boolean canBuy;
    
    public VendingMachine (Item[] items)
    {
        this.items = items;
        
        mVal = 0;
        AMOUNT_FOR_RESTOCK = 10;
    }
    
    public VendingMachine (Item[] items, int amtForRestock)
    {
        this.items = items;
        
        mVal = 0;
        AMOUNT_FOR_RESTOCK = amtForRestock;
    }
    
    private boolean checkInventory (int index)
    {
        return items[index].getNum() > 0;
    }
    
    public String getInventory()
    {
        String complex = "\n";
        
        for (int i = 0; i < items.length; i++)
            complex += "There are " + items[i].getNum() + " " + items[i].getName() + "s left in the vending machine. "
                    + "(Costs $" + items[i].getPrice() + ")" + "\n";
        
        return complex;
    }
    
    public void addMoney(double amt)
    {
        if (amt < 0)
            return;
        else
            mVal += amt;
    }
    
    public String refresh()
    {
        double temp = mVal;
        mVal = 0;
        return "Here is your money: $" + temp;
    }
    
    public void restock (int index)
    {
        items[index].setNum(AMOUNT_FOR_RESTOCK);
    }
    
    public String purchase(String item)
    {
        int index = 0;
        
        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getName().toLowerCase().equals(item.toLowerCase()))
            {
                index = i;
                break;
            }
        }
        
        if (mVal >= items[index].getPrice())
        {
            items[index].setNum(items[index].getNum() - 1);
            prompt = "Here is your " + items[index] + ". Here is your change of $" + (mVal - items[index].getPrice()) + ". Have a nice day!";
            mVal = 0;
        }
        else
        {
            prompt = "You do not have enough money to buy this drink. Please enter more money.";
        }
            
        
        if (!checkInventory(index))
            restock(index);
        
        return prompt;
    }
    
    
}
