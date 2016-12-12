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
        
        int sFail = 0;
        int temp = 0;
       
        for(Student i : sArr){
            System.out.println(i);
            if(i.getGrade() < 60){
                sFail ++;
            }
            temp += i.getGrade();
        }
        
        System.out.println("School average: " + temp / sArr.length);
        System.out.println("School size: " + sArr.length);
        System.out.println("Failing students: " + sFail);
        
        for(int i = 9; i <= 12; i++){
            sFail = 0;
            temp = 0;
            ArrayList<Student> sGrade = new ArrayList<>();
            for(int j = 0; j < sArr.length; j++){
                if(j==0)
                    System.out.println("Year " + i);
                if(sArr[j].getYear() == i){
                    sGrade.add(sArr[j]);
                    if(sArr[j].getGrade() < 60){
                        sFail ++;
                    }
                    temp += sArr[j].getGrade();
                }
            }
        if (sGrade.isEmpty())
            System.out.println("School average: " + temp);
        else
            System.out.println("School average: " + temp / sGrade.size());
        System.out.println("School size: " + sGrade.size());
        System.out.println("Failing students: " + sFail);
        }
    }
    
}
