/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mehme_000
 */
public class BankingTransaction {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("Accounts.txt");
        Scanner scf = new Scanner(f).useDelimiter(",");
        ArrayList<Account> a = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();
        
        while(scf.hasNext()){
            comp.add(scf.nextInt());
        }
        
        for(int i = 0; i < comp.size(); i += 5){
            for(int j = 0; j < 5; j++){
                a.add(new Account(comp.get(j), comp.get(j+1)));
            }
        }
            
        
        Calendar cal = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank of AnsulKamath, today's date is "
                + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR));
        System.out.println("Please input your account ID: ");
        int ID = sc.nextInt();
        System.out.println("Please input your pin: ");
        int pin = sc.nextInt();
        
       
        System.out.println("Enter \"s\" for your summary statement, \"check\" for your checking account, \nor \"save\" for your summary statement");
        
        
    }
    
}
