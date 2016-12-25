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
public class Cube
{
    private ArrayList<Node> debris;
    private ArrayList<Node> hive;
    private ArrayList<Node> cube;
    Bee[] bees = new Bee[15];
    int size;
    
    public Cube ()
    {
        debris = new ArrayList();
        hive = new ArrayList();
        cube = new ArrayList();
    }
    
    public Cube(int size)
    {
        debris = new ArrayList();
        hive = new ArrayList();
        cube = new ArrayList();
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                for (int z = 0; z < size; z++)
                    cube.add(new Node(x, y, z));
    }
    
    public void addDebris (Node[] d)
    {
        debris = new ArrayList<>(Arrays.asList(d));
    }
    
    public void addDebris(Node d)
    {
        debris.add(d);
    }
    
    public void addHive (Node[] h)
    {
        hive = new ArrayList<>(Arrays.asList(h));
    }
    
    public void removeHive(Node h)
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
    
    public ArrayList<Node> getDebris()
    {
        return debris;
    }
    
    public ArrayList<Node> getHive()
    {
        return hive;
    }
    
    public ArrayList<Node> getCube()
    {
        return cube;
    }
    
    // Converts a hive space to a debris space
    public void toDebris(Node h)
    {
        removeHive(h);
        addDebris(h);
    }
}
