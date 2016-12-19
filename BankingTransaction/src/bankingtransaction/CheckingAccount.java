/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 * @author anshulkamath
 */

public class CheckingAccount extends Account{
    
    private final double overdraft;
    
    public CheckingAccount(int ID, double amt, double overdraft) throws FileNotFoundException, IOException{
        super(ID,amt);
        this.overdraft = overdraft;
    }

    @Override
    public String withdraw(int with) throws IOException{
        if(getAmount()-with > -overdraft){
            super.withdraw(with);
        }
        else{
            return("Withdrawal Denied! /nYou only have  $" + getAmount() + " in your account with an overdraft of " + df.format(overdraft) + ".");  
        }
        return null;
    }
}
