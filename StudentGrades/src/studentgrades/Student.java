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
    private boolean isPassing;
    private TreeMap<String, Integer> courses = new TreeMap();
    private Object[] gradeList;

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
}
