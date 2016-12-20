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
public class Location implements Comparable<Location>
{
    private int x, y, z;
    
    public Location (int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

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

    @Override
    public int compareTo(Location o)
    {
        int dX = (o.x - this.x) * (o.x - this.x);
        int dY = (o.y - this.y) * (o.y - this.y);
        int dZ = (o.z - this.z) * (o.z - this.z);
        
        return (int)(Math.sqrt(dX + dY + dZ));
    }
    
    
}
