/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beeproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author anshulkamath
 */
public class BeeProject
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, Exception
    {
        
    }
    
    public Hive fileIO() throws Exception{
        int fileNum, size;
        
        File f[] = new File[3];
        Scanner scf[] = new Scanner[3];
        
        Location[] hiveLoc = new Location[15];
        Hive hive = new Hive();
        Bee[] bee = new Bee[15];
        
        f[0] = new File("beesetup1.txt");
        f[1] = new File("beesetup2.txt");
        f[2] = new File("beesetup3.txt");
        
        for(int i = 0; i < f.length; i++)
        {
            scf[i] = new Scanner(f[i]).useDelimiter("\n");
            fileNum = scf[i].nextInt();
            size = scf[i].nextInt();
            hive = new Hive(size);
            
            for(int j = 0; j < 15; j++){
                hiveLoc[j] = new Location(scf[i].nextInt(),scf[i].nextInt(),scf[i].nextInt());
            }
            
            for(int j = 0; j < 15; j++){
                bee[j] = new Bee(j+1,new Location(scf[i].nextInt(),scf[i].nextInt(),scf[i].nextInt()));
            }
            
            int debrisAmt = scf[i].nextInt();
            Location[] debrisLoc = new Location[debrisAmt];
            
            for(int j = 0; j < debrisLoc.length; j++){
                debrisLoc[j] = new Location(scf[i].nextInt(),scf[i].nextInt(),scf[i].nextInt());
            }
            
            hive.addHive(hiveLoc);
            hive.addDebris(debrisLoc);
            hive.addBees(bee);
            
        }
        return hive;
    }
    
    public void algo(Hive h){
        
    }
}
