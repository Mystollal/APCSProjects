/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investmentproj;

/**
 *
 * @author anshulkamath
 */
public class InvestmentProj
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Investment adam = new MutualFund("Adam", 100, 540.12);
        System.out.println(adam);
        Investment james = new CD("James", 5000, 5, 365);
        System.out.println(james);
    }
    
}
