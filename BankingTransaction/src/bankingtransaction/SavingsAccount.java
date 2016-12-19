/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author anshulkamath
 */

public class SavingsAccount extends Account
{
    public SavingsAccount(int ID, double amt) throws FileNotFoundException, IOException
    {
        super(ID, amt);
    }
    
    @Override
    public String withdraw(int with) throws IOException{
        if(getAmount() - with > 0)
            super.withdraw(with);
        else 
            return("Withdrawal Denied! /nYou only have  $" + getAmount() + " in your account.");  
        return null;
    }    
}
