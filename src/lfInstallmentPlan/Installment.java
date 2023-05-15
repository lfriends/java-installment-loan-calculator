
package lfInstallmentPlan;

import java.util.Date;


/**
 *
 * @author Luca and Friends :: github.com/lfriends
 */
public class Installment {
    
    private final int number;
    private final double total;
    private final double principal;
    private final double interests;
    private final double outstandingPrincipal ;
    private double outstandingInterests; 
    private double debtPaid; 
    private final java.util.Date dueDate;

    public Installment(double installmentAmount, double initialAmount, int currentInstallmentNumber, int totalInstallmentsNumber, java.util.Date firstDueDate, double interestRate, Installment prevInstallment ) {
       
        this.number = currentInstallmentNumber;
        this.total = installmentAmount;
        if (currentInstallmentNumber==1){
            this.principal = installmentAmount - initialAmount * interestRate ;
        }else{
            this.principal = prevInstallment .principal * (1 + interestRate) ;
        }
        this.interests = installmentAmount - principal ;
        
        this.outstandingPrincipal = installmentAmount * (1- Math.pow(1+interestRate , -(totalInstallmentsNumber-currentInstallmentNumber)) )/interestRate ; 
        this.outstandingInterests = 0 ; // on 2nd pass
        this.debtPaid = 0 ; // on 2nd pass
        
        if (currentInstallmentNumber==1){
            this.dueDate = firstDueDate;
        }else{
            int day = Utils.getDayOfMonth( firstDueDate );
            java.util.Date newDate = Utils.getFirstDayOfMonth( firstDueDate );
            newDate = Utils.addMonth( newDate, currentInstallmentNumber-1 );
            int month = Utils.getMonthNumber( newDate );
            newDate = Utils.addDay( newDate, day-1 );
            
            while ( month <  Utils.getMonthNumber( newDate ) )
                newDate = Utils.addDay( newDate, -1 );
                    
            this.dueDate =  newDate;
        }
    }

    public void updateOutstandingValues(Installment prevInst, double totInterests ){
        this.outstandingInterests = (prevInst==null ? totInterests  : prevInst.outstandingInterests ) - this.interests;
        this.debtPaid = (prevInst==null ? 0 : prevInst.debtPaid ) + this.principal;
    }

    public int getNumber() {
        return number;
    }

    public double getTotalAmount() {
        return total;
    }

    public double getPrincipalAmount() {
        return principal;
    }

    public double getInterestAmount() {
        return interests;
    }

    public double getOutstandingPrincipal() {
        return outstandingPrincipal;
    }

    public double getOutstandingInterests() {
        return outstandingInterests;
    }

    public double getDebtPaid() {
        return debtPaid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return 
            "Installment{#=" + number 
             + ", dueDate=" + Utils.date2s(dueDate) 
             + ", total=" + Utils.double2s(total) 
             + ", principal=" + Utils.double2s(principal) 
             + ", interests=" + Utils.double2s(interests) 
             + ", outstandingPrincipal=" + Utils.double2s(outstandingPrincipal) 
             + ", outstandingInterests=" + Utils.double2s(outstandingInterests) 
             + ", debtPaid=" + Utils.double2s(debtPaid) 
             + '}';
    }
    
    
}
