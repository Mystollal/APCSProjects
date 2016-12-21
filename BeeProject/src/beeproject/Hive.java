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
    ArrayList<Location> hive;
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
    
    public void addDebris(Location d)
    {
        debris.add(d);
    }
    
    public void addHive (Location[] h)
    {
        hive = new ArrayList<>(Arrays.asList(h));
    }
    
    public void removeHive(Location h)
    {
        hive.remove(h);
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
    
    public ArrayList<Location> getHive()
    {
        return hive;
    }
    
    public void toDebris(Location h){
        removeHive(h);
        addDebris(h);
    }
}
