/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author anshulkamath
 */
public class Student implements Comparable<Student>
{
    private static int numStudents = 0;
    private String lastName, firstName, ssn;
    private int year;
    private int grade;
    private boolean isPassing;
    private TreeMap<String, Integer> courses = new TreeMap();
    private Object[] gradeList;
    private String letterGrade;
    
    public Student(String lastName, String firstName, String ssn, int year, String course, int courseGrade)
    {
        numStudents++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.year = year;
        courses.put(course, courseGrade);     
    }
    
    // Getters and Setters
    public int getGrade(){
        calcAvg();
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName)
    { this.lastName = lastName; }

    public String getFirstName()
    { return firstName; }

    public void setFirstName(String firstName)
    { this.firstName = firstName; }

    public String getSsn()
    { return ssn; }

    public void setSsn(String ssn)
    { this.ssn = ssn; }

    public int getYear()
    { return year; }

    public void calcLetter()
    { 
        if(grade >= 93)
            letterGrade = "A";
        else if(grade >= 90)
            letterGrade = "A-";
        else if(grade >= 87)
            letterGrade = "B+";
        else if(grade >= 83)
            letterGrade = "B";
        else if(grade >= 80)
            letterGrade = "B-";
        else if(grade >= 77)
            letterGrade = "C+";
        else if(grade >= 73)
            letterGrade = "C";
        else if(grade >= 70)
            letterGrade = "C-";
        else if(grade >= 67)
            letterGrade = "D+";
        else if(grade >= 63)
            letterGrade = "D";
        else if(grade >= 60)
            letterGrade = "D-";
        else
            letterGrade = "F";
    }
    
    public void calcAvg()
    { 
        gradeList = courses.values().toArray();
        
        int temp = 0;
        
        for (Object o : gradeList)
            temp += (int)o;
        
        grade = temp / gradeList.length;
    }
    
    public boolean setIsFailing()
    { return isPassing; }
    
    public void setIsPassing()
    { 
        if (grade > 60)
            isPassing = true;
        else
            isPassing = false;
    }
    
    public static int getNumStudents()
    { return numStudents; }

    public static void setNumStudents(int aNumStudents)
    { numStudents = aNumStudents; }
    
    public void addCourse (String course, int grade)
    {
        courses.put(course, grade);
    }
    
    public int getCourseGrade (String course)
    {
        return courses.get(course);
    }
    
    @Override
    protected void finalize()
    { numStudents--; }

    @Override
    public int compareTo(Student o) {
        calcAvg();
        return Integer.valueOf(grade).compareTo(o.getGrade());
    }
    
    @Override
    public String toString(){
        return year + "th grader " + firstName + " " + lastName + " has a " + letterGrade + " with an average of " + grade;
    }
}
