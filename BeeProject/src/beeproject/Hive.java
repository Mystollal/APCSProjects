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
    ArrayList<Location> hive = new ArrayList();
    
    public Hive(int cube)
    {
        
    }
    
    public void addDebris (Location d)
    {
        debris.add(d);
    }
    
    public void addHive (Location h)
    {
        hive.add(h);
    }
}
