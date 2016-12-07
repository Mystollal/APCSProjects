/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgrades;

import java.util.TreeMap;

/**
 *
 * @author anshulkamath
 */
public class Student
{
    private static int numStudents = 0;
    private String lastName, firstName, ssn;
    private int grade;
    private boolean isFailing;
    private TreeMap<String, Integer> courses = new TreeMap();

    public Student(String lastName, String firstName, String ssn, int grade, String course, int courseGrade)
    {
        numStudents++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.grade = grade;
        courses.put(course, courseGrade);
    }
    
    
    // Getters and Setters
    public String getLastName()
    { return lastName; }

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

    public int getGrade()
    { return grade; }

    public void setGrade()
    { this.grade = grade; }
    
    public boolean getIsFailing()
    { return isFailing; }
    
    public void setIsFailing()
    { 
        if (grade < 60)
            isFailing = true;
        else
            isFailing = false;
    }
    
    public static int getNumStudents()
    { return numStudents; }

    public static void setNumStudents(int aNumStudents)
    { numStudents = aNumStudents; }
    
    @Override
    protected void finalize()
    { numStudents--; }
}
