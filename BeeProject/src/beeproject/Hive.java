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
public class Hive
{
    ArrayList<Location> debris = new ArrayList();
    Location[] hive;
    Bee[] bees = new Bee[15];
    
    public Hive(int cube)
    {
        
    }
    
    public void addDebris (ArrayList<Location> d)
    {
        debris = d;
    }
    
    public void addHive (Location[] h)
    {
        hive = h;
    }
    
    public void addBees (Bee[] b)
    {
        bees = b;
    }
}
