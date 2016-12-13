/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentproj;

/**
 *
 * @author anshulkamath
 */
public class CD extends Investment
{
    // Variables
    private double amount;
    private double ratePerYear;
    private int term;
    
    // Constructors
    public CD ()
    {
        amount = 0;
        ratePerYear = 0;
        term = 0;
        calcValue();
    }
    
    public CD (double amt, double rt, int trm)
    {
        amount = amt;
        ratePerYear = rt;
        term = trm;
        calcValue();
    }
    
    public CD (String name, double amt, double rt, int trm)
    {
        super(name);
        amount = amt;
        ratePerYear = rt;
        term = trm;
        calcValue();
    }
    
    public CD (String name, String phone, String ssn, int age, double amt, double rt, int trm)
    {
        super(name, phone, ssn, age);
        amount = amt;
        ratePerYear = rt;
        term = trm;
        calcValue();
    }
    
    // Implement abstract methods
    @Override
    public void calcValue()
    {
        setValue(((int)((amount * (term * (ratePerYear/365))) * 100)) / 100.0);
    }

    // toString()
    @Override
    public String toString() 
    {
        return "This is " + getName() + "'s CD and it is worth " + getValue();
    }
    
}
