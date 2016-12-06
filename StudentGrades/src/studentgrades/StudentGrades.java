/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mehme_000
 */
public class StudentGrades {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File sL = new File("StudentLog.txt");
        Scanner sc = new Scanner(sL);
        ArrayList<String> SSN = new ArrayList<>();
        boolean SSNFound = false;
        
        while()
        while(sc.hasNext()){
            
            if(sc.hasNextInt() && !SSNFound){
                SSN = sc.next();
            }
        }
    }
    
}
