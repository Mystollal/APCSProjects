/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author anshulkamath
 */

public class Account
{
    private int ID, pin;

    public Account (int ID, int pin)
    {
       this.ID = ID;
       this.pin = pin;
    }

  	public int getID()
    {	return ID; }

  	public void setID(int ID)
    {	this.ID = ID;	}

  	public int getPin()
    {	return pin; }

  	public void setPin(int pin)
    {	this.pin = pin; }

}
