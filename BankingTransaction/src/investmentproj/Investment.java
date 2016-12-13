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
public abstract class Investment implements Comparable<Investment>
{
    // Variables
    private String name, phone, ssn;
    private int age;
    private double totalValue;
    
    // Constructors
    public Investment()
    {
        name = "John Doe";
        phone = "(666) - 666 - 6666";
        ssn = "1234567890";
        age = 50;
    }
    
    public Investment (String name)
    {
        this.name = name;
        phone = "(666) - 666 - 6666";
        ssn = "1234567890";
        age = 50;
    }
    
    public Investment(String name, String phone, String ssn, int age)
    {
        this.name = name;
        this.phone = phone;
        this.ssn = ssn;
        this.age = age;
    }
    
    // Comparable
    @Override
    public int compareTo(Investment o) 
    {
        return (int)(totalValue - o.totalValue);
    }
    
    // Abstract Methods
    public abstract void calcValue();
    
    // Getters and Setters
    public String getName()
    { return name; }

    public void setName(String name)
    { this.name = name; }

    public String getPhone()
    { return phone; }

    public void setPhone(String phone)
    { this.phone = phone; }

    public String getSsn()
    { return ssn; }

    public void setSsn(String ssn)
    { this.ssn = ssn; }

    public int getAge()
    { return age; }

    public void setAge(int age)
    { this.age = age; }

    public double getValue()
    { return totalValue; }

    protected void setValue(double totalValue)
    { this.totalValue = totalValue; }
    
}
