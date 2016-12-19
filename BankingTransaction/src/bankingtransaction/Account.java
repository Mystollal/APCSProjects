/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/**
 *
 * @author anshulkamath
 */

public class Account{
    private final int ID;
    private double amount;
    protected DecimalFormat df;
    private final File f = new File("TransactionHist.txt");
    private final FileWriter fw = new FileWriter(f,true);
    private final BufferedWriter bw = new BufferedWriter(fw);
    private final Scanner sc = new Scanner(f);

    public Account (int ID, double amt) throws FileNotFoundException, IOException{
       this.ID = ID;
       this.amount = amt;
       df = new DecimalFormat("$0.00");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String deposit(int dep) throws IOException{
        amount += dep;
        addTransaction(dep);
        return("Deposit Confirmed! \nYour new balance is " + df.format(amount));
    }

    public String withdraw(int with) throws IOException{
        amount -= with;
        addTransaction(-with);
        return("Withdrawal Confirmed! \nYour new balance is " + df.format(amount));
    }

    public void addTransaction(int dep) throws IOException{

        Calendar cal = Calendar.getInstance();
        if(this instanceof CheckingAccount)
            bw.write((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR) + "\t" + ID + "\tC\t" +  df.format(dep));
        else
            bw.write((cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR) + "\t" + ID + "\tS\t" +  df.format(dep));
        bw.newLine();
    }

    public String getTransaction() throws IOException{
        bw.close();
        String out = "";
        ArrayList<String> comp = new ArrayList<>();
        sc.useDelimiter("\t|\n");
        while(sc.hasNext()){
            comp.add(sc.next().trim());
        }
        for(int i = 2; i <= comp.size()-2; i += 4){
            if(Integer.parseInt(comp.get(i-1)) == ID){
                if(this instanceof CheckingAccount)
                    if(comp.get(i).equals("C"))
                        out += comp.get(i-2) + "\t" + comp.get(i+1) + "\n";
                if(this instanceof SavingsAccount)
                    if(comp.get(i).equals("S"))
                        out += comp.get(i-2) + "\t" + comp.get(i+1) + "\n";
            }
        }
        return "Deposits: \n" + out;
    }

}
