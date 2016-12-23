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
public class Item 
{
    private String name;
    private double price;
    private int num;
    
    public Item (String name)
    {
        this.name = name;
        price = 1.25;
        num = 10;
    }
    
    public Item (String name, double price)
    {
        this.name = name;
        this.price = price;
        num = 10;
    }
    
    public Item (String name, double price, int num)
    {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public String toString()
    {
        return name;
    }
    
}
