/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.util.Scanner;

/**
 *
 * @author anshulkamath
 */
public class VendingMain
{
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        VendingMachine vend = new VendingMachine(
                new String[]{"Poland Spring Water", "Coke", "Sprite", "Fanta", "Dr. Pepper"});
        
        boolean loop = true;
        
        System.out.println("Hello. Would you like to buy something from our vending machine? (y or n)");
        char answer = sc.next().toLowerCase().charAt(0);
            
        
        while (loop)
        {
            if (answer == 'y')
            {
               System.out.println("Please enter the amount of money you are putting in now. (Everything is 1.25)");
               vend.addMoney(sc.nextDouble());
               
               System.out.println("Here are our selections:");
               System.out.println(vend.getInventory());
               
               System.out.println("Please select a drink.");
               String ret = vend.purchase(sc.next());
               
               if (ret.endsWith("Please enter more money."))
                   continue;
               else
                    System.out.println(ret);
                
                System.out.println("Would you like to buy something else from our machine? (y or n)");
                answer = sc.next().toLowerCase().charAt(0);
                continue;
            }
            else if (answer == 'n')
                break;
            else
            {
                System.out.println("That is not a valid input. Would you like to buy something from our vending machine? (y or n)");
                answer = sc.next().toLowerCase().charAt(0);
                continue;
            }
                
        }
        
        System.out.println("Have a nice day!");
    }
    
}
