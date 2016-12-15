/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingtransaction;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mehme_000
 */
public class BankingTransaction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the bank of AnshulKamath, today's date is "
                + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR));
        System.out.println("Please input your account ID: ");
        long ID = sc.nextLong();
        System.out.println("Please input your pin: ");
        int pin = sc.nextInt();
    }
    
}
