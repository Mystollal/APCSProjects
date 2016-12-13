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
public class MutualFund extends Investment
{
    // Variables
    private int units;
    private double unitVal;
    
    // Constructors    
    public MutualFund ()
    {
        units = 0;
        unitVal = 0;
        calcValue();
    }
    
    public MutualFund(int units, double unitVal)
    {
        this.units = units;
        this.unitVal = unitVal;
        calcValue();
    }
    
    public MutualFund(String name, int units, double unitVal)
    {
        super(name);
        this.units = units;
        this.unitVal = unitVal;
        calcValue();
    }
    
    public MutualFund (String name, String phone, String ssn, int age, int units, double unitVal)
    {
        super(name, phone, ssn, age);
        this.units = units;
        this.unitVal = unitVal;
    }
    
    // Implementation of abstract methods
    @Override
    public void calcValue() 
    {
        setValue(((int)((units * unitVal) * 100)) / 100.0);
    }
    
    // toString
    @Override
    public String toString() 
    {
        return "This is " + getName() + "'s mutual fund and it is worth " + getValue() + " dollars.";
    }
    
    
}
