/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beeproject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author anshulkamath
 */
public class Hive
{
    ArrayList<Location> debris;
    Location[] hive;
    Bee[] bees = new Bee[15];
    int size;
    
    public Hive ()
    {
        
    }
    
    public Hive(int cube)
    {
        size = cube;
    }
    
    public void addDebris (Location[] d)
    {
        debris = new ArrayList<>(Arrays.asList(d));
    }
    
    public void addHive (Location[] h)
    {
        hive = h;
    }
    
    public void addBees (Bee[] b)
    {
        bees = b;
    }
    
    public Bee getBee(int index)
    {
        return bees[index];
    }
    
    public ArrayList<Location> getDebris()
    {
        return debris;
    }
    
    public Location[] getHive()
    {
        return hive;
    }
}
