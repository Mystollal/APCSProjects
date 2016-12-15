/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;
package bankaccount;

/**
 *
 * @author anshulkamath
 */

public class Account
{
    private int ID, pin;
    private double amount;
    private PrintWriter printFile = new PrintWriter(new File("TransactinoHist.txt"));
    private Scanner scanFile = new Scanner(new File("TransactinoHist.txt"));

    public Account (int ID, int pin, double amt)
    {
       this.ID = ID;
       this.pin = pin;
       this.amount = amt;
    }

  	public int getID()
    {	return ID; }

  	public void setID(int ID)
    {	this.ID = ID;	}

  	public int getPin()
    {	return pin; }

  	public void setPin(int pin)
    {	this.pin = pin; }

    public void addTransaction()
    {

    }

}
