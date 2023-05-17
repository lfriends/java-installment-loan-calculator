
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
    private double outstandingPrincipal ;
    private double outstandingInterests; 
    private double debtPaidPre; 
    private double debtPaidPost; 
    private final java.util.Date dueDate;

    public Installment(Plan plan, int currentInstallmentNumber, Installment prevInstallment ) {
       
        this.number = currentInstallmentNumber;
        this.total = plan.getSingleInstallmentAmount();
        
        if (currentInstallmentNumber==1){
            this.debtPaidPre = 0 ;
        }else{
            this.debtPaidPre = prevInstallment.debtPaidPre + Utils.myRound(prevInstallment.getPrincipalAmount(), plan.numberOfDecimals );
        }
        
        if (currentInstallmentNumber==1){
            principal = plan.getSingleInstallmentAmount() - plan.getPrincipalAmount() * plan.getInterestRatePerMonth()  ;
            debtPaidPre = 0 ;
        }else if (currentInstallmentNumber==plan.getNumberOfInstallments()){
            principal = plan.getPrincipalAmount() - this.debtPaidPre ;
            
        }else{
            this.principal = prevInstallment .principal * (1 + plan.getInterestRatePerMonth() ) ;
        }
        this.interests = plan.getSingleInstallmentAmount() - principal ;
        
        // outstanding principal
        if (prevInstallment==null){
            outstandingPrincipal = plan.getPrincipalAmount()-principal ;
            debtPaidPost = principal ;
        
        }else{

            if (currentInstallmentNumber!=plan.getNumberOfInstallments() ){
                this.outstandingPrincipal = prevInstallment.outstandingPrincipal - Utils.myRound( this.principal, plan.numberOfDecimals ) ; 
                debtPaidPost = prevInstallment.debtPaidPost + principal ;
            
            }else{
                this.outstandingPrincipal = 0 ;   
                debtPaidPost = plan.getPrincipalAmount() ;
            }
        }
        
        this.outstandingInterests = (prevInstallment==null ? plan.getInterestAmount()  : prevInstallment.outstandingInterests ) - this.interests;
        
        if (currentInstallmentNumber==1){
            this.dueDate = plan.getFirstDueDate();
        }else{
            int day = Utils.getDayOfMonth( plan.getFirstDueDate() );
            java.util.Date newDate = Utils.getFirstDayOfMonth( plan.getFirstDueDate() );
            newDate = Utils.addMonth( newDate, currentInstallmentNumber-1 );
            int month = Utils.getMonthNumber( newDate );
            newDate = Utils.addDay( newDate, day-1 );
            
            while ( month <  Utils.getMonthNumber( newDate ) )
                newDate = Utils.addDay( newDate, -1 );
                    
            this.dueDate =  newDate;
        }
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
        return debtPaidPost;
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
             + ", debtPaid=" + Utils.double2s(debtPaidPost) 
             + '}';
    }
    
    
}
