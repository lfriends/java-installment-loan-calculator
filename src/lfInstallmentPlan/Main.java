
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
       
        //System.out.print( (new Plan ( 10000, 12, 4.5, new java.util.Date() )).toStringAsTable() ); 
        //System.out.print( (new Plan ( 11000, 12, 4.5, new java.util.Date() , 1000 )).toStringAsTable() ); 
        //1if(true)return;
        
        System.out.println("====== Installment Calculator  ::  github.com/lfriends ======");
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the loan amount (Eg 10000):");
        String str_amount = scanner.nextLine();        
        System.out.println("Please enter the advance payment amount (Eg 1000 or 0):");
        String str_advance = scanner.nextLine();        
        System.out.println("Please enter the interest rate in % (Eg 4.5):");
        String str_interest = scanner.nextLine();
        System.out.println("Please enter the loan duration inmonts (Eg 12):");
        String str_months = scanner.nextLine();
        System.out.println("Please enter the first due date or press ENTER for current date (Format: DD/MM/YY .or. DDMMYY - Eg 31/12/23 or 311223):");
        String str_date = scanner.nextLine();

        java.util.Date startDate = null ;
        if (str_date.length()==6){
            startDate  = Utils.strf2date(str_date, "ddMMyy");
        }else if (str_date.length()==8){
            startDate  = Utils.strf2date(str_date, "dd/MM/yy");
        }else{
            startDate  = new java.util.Date() ;
        }
        
        double initialAmount = Double.parseDouble(str_amount);
        double advanceAmount = Double.parseDouble(str_advance);
        double taxRatePerc = Double.parseDouble(str_interest); 
        int numberOfMonths = Integer.parseInt(str_months) ;
        
        // ----------------------------------------
        Plan p = new Plan ( initialAmount, numberOfMonths, taxRatePerc, startDate , advanceAmount );
        // ----------------------------------------
        
        System.out.print( p.toStringAsTable() );
        
    }
    
}
