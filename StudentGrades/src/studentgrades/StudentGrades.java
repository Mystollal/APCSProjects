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
        ArrayList<String> components = new ArrayList<>();
        sc.useDelimiter(",");
        ArrayList<Student> s = new ArrayList<>();
        
        while(sc.hasNext()){
            components.add(sc.next().trim());
        }
        
        int studNum = components.size() / 6;
        
        outerloop:
        for(int i = 0; i < components.size() - 6; i+=6){
            if(i >= 6){
                for(int j = 0; j < s.size(); j++)
                    if(components.get(i+2).equals(s.get(j).getSsn())){
                        s.get(j).addCourse(components.get(i+4),Integer.parseInt(components.get(i+5)));
                        continue outerloop;
                    }
            }
            s.add(new Student(components.get(i), components.get(i+1),components.get(i+2),Integer.parseInt(components.get(i+3)),components.get(i+4),Integer.parseInt(components.get(i+5))));
        }
        
        Student[] sArr= s.toArray(new Student[s.size()]);
        SortAll.selectionSort(sArr);
        
        for(Student i : sArr){
            i.calcAvg();
            i.calcLetter();
            System.out.println(i);
        }
    }
    
}
