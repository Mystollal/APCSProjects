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
    private Node loc;
    private int numMoves;
    private Node nearestHive;

    public Bee(int beeNum, Node loc) throws Exception
    {
        if (numBees > 15)
            throw new Exception("There are too many bees!!!");
        this.beeID = beeNum;
        this.loc = loc;
        numMoves = 0;
        numBees++;
    }

    public Node getNode() {
        return loc;
    }

    public int getNumMoves() {
        return numMoves;
    }
    
    public void addMove()
    {
        numMoves++;
    }
    
    public void setNearestHive(Cube cube)
    {
        int dist = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < cube.getHive().size(); i++)
        {
            if (loc.compareTo(cube.getHive().get(i)) < dist)
            {
                dist = loc.compareTo(cube.getHive().get(i));
                index = i;
            }
        }
        // Gets the cube closest cube by index
        nearestHive = cube.getHive().get(index);
    }
    
    public Node getNearestHive()
    {
        return nearestHive;
    }
    
    @Override
    public String toString()
    {
        return "Bee number: " + beeID + " @ location: " + loc.toString() + " trying to get the hive @ location " + nearestHive;
    }
}
