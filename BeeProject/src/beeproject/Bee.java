/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beeproject;

import java.util.ArrayList;

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
    private Location nearestHive;

    public Bee(int beeNum, Location loc) throws Exception
    {
        if (numBees > 15)
            throw new Exception("There are too many bees!!!");
        this.beeID = beeNum;
        this.loc = loc;
        numMoves = 0;
        numBees++;
    }
    
    public boolean nearDebris (ArrayList<Location> debris)
    {
        for (int i = 0; i < debris.size(); i++)
            if (loc.compareTo(debris.get(i)) <= 2)
                return false;
        return true;
    }
    
    public boolean nearDebris (Location debris)
    {
        return loc.compareTo(debris) <= 2;
    }
    
    public void nearestHive(Hive hive)
    {
        int dist = 1000000000;
        int index = -1;
        for(int i = 0; i < hive.getHive().size(); i++)
        {
            if (loc.compareTo(hive.getHive().get(i)) < dist)
            {
                dist = loc.compareTo(hive.getHive().get(i));
                index = i;
            }
        }
        
        nearestHive = hive.getHive().get(index);
    }
    
    public Location getNearestHive()
    {
        return nearestHive;
    }
}
