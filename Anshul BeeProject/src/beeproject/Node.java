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
public class Node implements Comparable<Node>
{
    private int x, y, z, gCost, hCost, fCost;
    private Node parentNode;
    
    public Node ()
    {
        x = 0;
        y = 0;
        z = 0;
        gCost = 0;
        hCost = 0;
        fCost = Integer.MAX_VALUE;
    }
    
    public Node (int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getGCost() {
        return gCost;
    }

    public void setGCost(Node loc) {
        this.gCost = this.compareTo(loc);
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(Node loc) {
        this.hCost = this.compareTo(loc);
    }
    
    public int getFCost() {
        return fCost;
    }

    public void setFCost() {
        this.fCost = this.gCost + this.hCost;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }
    
    public boolean hasParentNode() {
        return parentNode != null;
    }
    

    // Finds the distance
    @Override
    public int compareTo(Node o)
    {
        int dX = (o.x - this.x) * (o.x - this.x);
        int dY = (o.y - this.y) * (o.y - this.y);
        int dZ = (o.z - this.z) * (o.z - this.z);
        
        return (int)(Math.sqrt(dX + dY + dZ) * 10);
    }
    
    
    public String toString()
    {
        return x + "," + y + "," + z;
    }
    
    // So that the .contains method will work with new instances of the class
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        
        final Node location = (Node) obj;
        
        if (this.x != location.x || this.y != location.y || this.z != location.z)
            return false;
        return true;
    }
}
