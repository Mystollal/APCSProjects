/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beeproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author anshulkamath
 */
public class BeeProject
{
    static Cube cube;
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, Exception
    {
        
        cube = fileIO();
        nearestHive();
        printResults();
    }
    
    public static Cube fileIO() throws Exception
    {
        // Template: File Number, cube size, cube nodes, bee nodes, number of debris, debris nodes
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, which bee file would you like me to read from? (1, 2, or 3)");
        String file = "beesetup" + sc.next() + ".txt";
        
        sc = new Scanner(new File(file)).useDelimiter("\n");
        
        sc.nextLine();
        
        // Splits it into an array delimited by ','s
        int size = Integer.parseInt(sc.next().split(",")[0]);
        
        Node[] hiveLoc = new Node[15];
        Node[] debrisLoc;
        Bee[] bee = new Bee[15];
        Cube cube = new Cube(size);
        String[] temp;
        
        for (int i = 0; i < 15; i++)
        {
            temp = sc.next().split(",");
            hiveLoc[i] = new Node(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }
        
        for (int i = 0; i < 15; i++)
        {
            temp = sc.next().split(",");
            bee[i] = new Bee(i + 1, new Node(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            cube.getCube().remove(bee[i].getNode());
        }
        
        debrisLoc = new Node[Integer.parseInt(sc.next())];
        
        for (int i = 0; i < debrisLoc.length; i++)
        {
            temp = sc.next().split(",");
            debrisLoc[i] = new Node(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
            cube.getCube().remove(debrisLoc[i]);
        }
        

        cube.addHive(hiveLoc);
        cube.addDebris(debrisLoc);
        cube.addBees(bee);
        
        return cube;
    }
    
    public static void nearestHive()
    {
        for(int i = 0; i < 15; i++)
        {
            cube.getBee(i).setNearestHive(cube);
            cube.toDebris(cube.getBee(i).getNearestHive());
        }
    }
    
    
    public static ArrayList<Node> calcNextTo(Node nd, Node hive)
    {
        ArrayList<Node> adjacents = new ArrayList();
        
        // For loop to find all the possible moves that the bee can do
        for (int i = -1; i < 2; i++) 
            for (int j = -1; j < 2; j++)
                for (int k = -1; k < 2; k++)
                    if (i == 0 && j == 0 && k == 0)
                        continue;
                    else
                        adjacents.add(new Node(nd.getX() + i, nd.getY() + j, nd.getZ() + k));
        
        // Gets rid of the error thrown when trying to remove an element from
        // an arraylist in a loop
        for (Iterator<Node> itr = adjacents.iterator(); itr.hasNext();)
        {
            Node temp = itr.next();
            if (cube.getDebris().contains(temp))
                itr.remove();
        }
        
        // Calculates the gCost and hCost of each of the nodes and parents them
        // automatically
        for (Node node : adjacents)
        {
            node.setGCost(nd);
            node.setHCost(hive);
            node.setFCost();
            node.setParentNode(nd);
        }
        
        // Checks to see if the target node is in the adjacent selection, in
        // which case a new arraylist will be returned that only has the target
        // node
        for(Node node : adjacents)
        {
            if (node.equals(hive))
            {
                ArrayList<Node> hiveLoc = new ArrayList();
                hiveLoc.add(node);
                return hiveLoc;
            }
                
        }
        
        return adjacents;
    }
    
    
    // Algorithm rundown/pseudocode
    /*
        Terms to know:
            gCost - the distance away from the starting point
            hCost - the distance away from the end point
            fCost - the sum of the gCost and the hCost

        Get current node (bee origin)
        loop
            Add the current node to the closed list
            Find the nearest nodes
            Check to see if any of the nearest nodes are the hive location 
                (which is taken care of in the calcNextTo function)
            Remove the nodes that are already closed
            Determine if there is a better path for the open nodes by:
                Taking the gCost of the current node and adding the movement
                cost and then comparing that to the original node gCost

                IF YES - re-parent the node so that the node is no longer
                         pointing to the slower path

    */
    public static void findPath(Bee bee)
    {
        // Declaring all variablese
        ArrayList<Node> open = new ArrayList();
        ArrayList<Node> closed = new ArrayList();
        ArrayList<Node> adjacents = new ArrayList();
        ArrayList<Node> path = new ArrayList();
        Node current = bee.getNode();
        Node smallest = new Node();
        
        while (current.compareTo(bee.getNearestHive()) > 20)
        {
            closed.add(current);
            adjacents = calcNextTo(current, bee.getNearestHive());
            
            if (adjacents.get(0) == bee.getNearestHive())
                break;
            
            for (Node nd : adjacents)
            {
                if (!closed.contains(nd)) // if the adjacent nodes arent in closed
                    open.add(nd);     // they are now in open
                
                else if (open.contains(nd))   // if the adjacent nodes are already in
                {                    // open, check to see if we can reparent
                    // Basically, if it is shorter to go from A -> C than A -> B -> C
                    if (nd.getGCost() < current.getGCost() + (current.compareTo(nd)))
                        nd.setParentNode(current);
                    else
                        continue;
                }
            }
            
            for (Node nd : open)
                if (nd.getFCost() < smallest.getFCost())
                    smallest = nd;
            
            current = smallest;
            bee.addMove();
        }
        // Adjacent only has the starting node inside of it now. Need to 
        // compensate for the last move for all bees.
        adjacents = calcNextTo(current, bee.getNearestHive());
        bee.addMove();
        Node nextNode = adjacents.get(0);
        
        while(true)
        {
            if (nextNode.hasParentNode())
            {
                path.add(nextNode);
                nextNode = nextNode.getParentNode();
            }
            else
                break;
        }
        
        for (int i = path.size() - 1; i > 0; i--)
            System.out.println(path.get(i));
        
    }
    
    public static void printResults()
    {
        int totalMoves = 0;
        for (int i = 0; i < 15; i++)
        {
            System.out.println(cube.getBee(i));
            System.out.println("Path:");
            findPath(cube.getBee(i));
            System.out.println(cube.getBee(i).getNearestHive());
            System.out.println("Number of moves: " + (cube.getBee(i).getNumMoves()));
            System.out.println("");
            
            totalMoves += cube.getBee(i).getNumMoves();
        }
        
        System.out.println("The total amount of moves: " + totalMoves);
    }
    
}
