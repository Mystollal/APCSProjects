/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beeproject;

/**
 *
 * @author anshulkamath
 */
public class Bee
{
    private int beeID;
    private static int numBees = 0;
    private Location loc;
    private int numMoves;

    public Bee(int beeNum, Location loc) throws Exception
    {
        if (numBees > 15)
            throw new Exception("There are too many bees!!!");
        this.beeID = beeNum;
        this.loc = loc;
        numMoves = 0;
        numBees++;
    }
    
    
    
}
