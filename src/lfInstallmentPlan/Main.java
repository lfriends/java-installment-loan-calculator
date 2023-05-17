
package lfInstallmentPlan;

import java.util.Scanner;

/**
 *
 * @author Luca and Friends :: github.com/lfriends
 */
public class Main {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //System.out.print( (new Plan ( 10000, 12, 4.5, new java.util.Date()  )).toStringAsTable() );
        
        System.out.println("====== Installment Calculator  ::  github.com/lfriends ======");
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the loan amount (Eg 10000):");
        String str_amount = scanner.nextLine();        
        System.out.println("Please enter the interest rate in % (Eg 4.5):");
        String str_interest = scanner.nextLine();
        System.out.println("Please enter the loan duration inmonts (Eg 12):");
        String str_months = scanner.nextLine();
        System.out.println("Please enter the 1st due date (DD/MM/YY .or. DDMMYY) (Eg 31/12/23 .or 311223):");
        String str_date = scanner.nextLine();

        java.util.Date startDate = null ;
        if (str_date.length()==6){
            startDate  = Utils.strf2date(str_date, "ddMMyy");
        }else{
            startDate  = Utils.strf2date(str_date, "dd/MM/yy");
        }
        
        double initialAmount = Double.parseDouble(str_amount);
        double taxRatePerc = Double.parseDouble(str_interest); 
        int numberOfMonths = Integer.parseInt(str_months) ;
        
        // ----------------------------------------
        Plan p = new Plan ( initialAmount, numberOfMonths, taxRatePerc, startDate  );
        // ----------------------------------------
        
        System.out.print( p.toStringAsTable() );
        
    }
    
}
