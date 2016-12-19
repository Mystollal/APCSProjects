/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException
    {
        File f = new File("Accounts.txt");
        File f2 = new File("TransactionHist.txt");
        PrintWriter pw = new PrintWriter(f2);
        Scanner scf = new Scanner(f).useDelimiter(",");
        ArrayList<Account> a = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();
        int acc = 0;
        String in = null;
        
        while(scf.hasNext()){
            comp.add(Integer.parseInt(scf.next().trim()));
        }

        Calendar cal = Calendar.getInstance();
        boolean active = true, active2 = true;
        outerloop:
        while(active){
            System.out.println("Welcome to the bank of AnsulKamath, today's date is "
                    + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR)
                    + "\nIf at any point you want to end your transaction, enter \"Q\"");

            System.out.println("Please input your account ID: ");
            in = sc.next().toLowerCase();
            if(in.equals("q"))
                break outerloop;
            int ID = Integer.parseInt(in);
            System.out.println("Please input your pin: ");
            in = sc.next().toLowerCase();
            if(in.equals("q"))
                break outerloop;
            int pin = Integer.parseInt(in);

            for(int i = 0; i < comp.size(); i +=5){
                if(comp.get(i) == ID && comp.get(i+1) == pin){
                    acc = i;
                    break;
                }
                else
                    acc = -1;
            }
            if(acc == -1){
                System.out.println("Your ID or Pin could not be found, please try again.");
                Thread.sleep(2000);
                continue;
            }
            
            System.out.println("Welcome, Valued Customer " + ID);
            Account ca = null;
            Account sa = null;
            
            if(comp.get(acc + 2) != 0)
                ca = new CheckingAccount(comp.get(acc),comp.get(acc+2), comp.get(acc+4));
            if(comp.get(acc + 3) != 0)
                sa = new SavingsAccount(comp.get(acc),comp.get(acc+3));
            while(active2){
                if(sa != null && ca != null){
                    System.out.println("Enter \"s\" for your savings account or \"c\" for your checking account");
                    in = sc.next().toLowerCase();
                }
                else
                    in = null;
            
                if(sa == null || in.equals("c")){
                    System.out.println("Enter \"s\" for your summary statement, \"d\" for a deposit, or \"w\" for a withdrawal:");
                    in = sc.next().toLowerCase();
                    if(in.equals("q"))
                        break outerloop;
                    if(in.equals("s")){
                        System.out.println(ca.getTransaction());
                    }
                    if(in.equals("d")){
                        System.out.println("How much would you like to deposit:");
                        in = sc.next().toLowerCase();
                        System.out.println(ca.deposit(Integer.parseInt(in)));
                    }
                    if(in.equals("w")){
                        System.out.println("How much would you like to withdraw:");
                        in = sc.next().toLowerCase();
                        System.out.println(ca.withdraw(Integer.parseInt(in)));
                    }
                }
                else if(ca == null || in.equals("s")){
                    System.out.println("Enter \"s\" for your summary statement, \"d\" for a deposit, or \"w\" for a withdrawal:");
                    in = sc.next().toLowerCase();
                    if(in.equals("q"))
                        break outerloop;
                    if(in.equals("s")){
                        System.out.println(sa.getTransaction());
                    }
                    if(in.equals("d")){
                        System.out.println("How much would you like to deposit:");
                        in = sc.next().toLowerCase();
                        System.out.println(sa.deposit(Integer.parseInt(in)));
                    }
                    if(in.equals("w")){
                        System.out.println("How much would you like to withdraw:");
                        in = sc.next().toLowerCase();
                        System.out.println(sa.withdraw(Integer.parseInt(in)));
                    }
                }
                System.out.println("Would you like to perform another action?(y/n):");
                in = sc.next().toLowerCase();
                if(in.equals("y"))
                    continue;
                else if (in.equals("q"))
                    break outerloop;
                else
                    break;
            }
        }
        
        pw.close();
    }
}
