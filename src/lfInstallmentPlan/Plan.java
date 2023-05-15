
package lfInstallmentPlan;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luca and Friends :: github.com/lfriends
 */
public class Plan {
    

    private int numberOfInstallments; 
    private double interestRatePerYear;
    private double interestRatePerMonth;
    private double totalAmount; 
    private double principalAmount;
    private double interestAmount;
    private double singleInstallmentAmount;
    private java.util.Date firstDueDate;
    private java.util.Date lastDueDate;

    java.util.List<Installment> installments ;

    public Plan(double principal, int numberOfInstallments, double interestRateYear, java.util.Date firstDueDate ){
        setPrincipalAmount(principal);
        setInterestRate(interestRateYear);
        setNumberOfInstallments(numberOfInstallments);
        setFirstDueDate(firstDueDate);
        doCalculate();
    }
    
    
    public void doCalculate(){

        this.singleInstallmentAmount = principalAmount * interestRatePerMonth /  (1- Math.pow(1+interestRatePerMonth , -numberOfInstallments) ) ;

        this.installments = new java.util.ArrayList<>();
        
        for (int currentInstallmentNumber =1;currentInstallmentNumber <= numberOfInstallments; currentInstallmentNumber ++)
        {
            Installment prevInst = null;
            if (currentInstallmentNumber >1) prevInst = installments.get(currentInstallmentNumber -2) ;
            Installment newInst = new Installment( singleInstallmentAmount, principalAmount, currentInstallmentNumber , numberOfInstallments, firstDueDate, interestRatePerMonth, prevInst ) ;
            installments.add( newInst ) ;
            this.lastDueDate = newInst.getDueDate() ;
        }  
        
        totalAmount=0;
        interestAmount=0;
        for(Installment r :installments){
            this.totalAmount += r.getTotalAmount();
            this.interestAmount += r.getInterestAmount();
        }
        
        for(Installment r :installments){
            Installment prevInst = null ;
            if (r.getNumber()>1) prevInst = installments.get( r.getNumber()-2 );
            r.updateOutstandingValues(prevInst, this.interestAmount);
        }    
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public void setInterestRate(double feePercentage) {
        this.interestRatePerYear = feePercentage;
        this.interestRatePerMonth=feePercentage/12/100;
    }

    public void setPrincipalAmount(double principal) {
        this.principalAmount = principal;
    }

    public void setFirstDueDate(Date firstDueDate) {
        this.firstDueDate = firstDueDate;
    }    

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public double getInterestRate() {
        return interestRatePerYear;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public double getSingleInstallmentAmount() {
        return singleInstallmentAmount;
    }

    public Date getFirstDueDate() {
        return firstDueDate;
    }

    public Date getLastDueDate() {
        return lastDueDate;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    @Override
    public String toString() {
        return "Plan{" 
                + "duration=" + numberOfInstallments 
                + ", interest%=" + interestRatePerYear 
                + ", principal=" + Utils.double2s(principalAmount) 
                + ", interest=" + Utils.double2s(interestAmount) 
                + ", total=" + Utils.double2s(totalAmount) 
                + ", installment=" + Utils.double2s(singleInstallmentAmount) 
                + ", firstDueDate=" + Utils.date2s(firstDueDate) 
                + ", lastDueDate=" + Utils.date2s(lastDueDate) 
                + ", installments=" + installments + '}';
    }
    
    public String toStringAsTable(){
        String res = "" ;
        StringBuilder sb = new StringBuilder();
		
        int x = Utils.double2s(this.getTotalAmount() ).length() ;
        if (x<8)x=8;

        String line =  Utils.rpad( "", 5 + ((x+3)*6), "-") + "\n";
        
        sb.append( line);     
        sb.append(Utils.rpad("Principal ",25,".")).append(" ").append(Utils.double2s(this.getPrincipalAmount() )).append("\n");
        sb.append(Utils.rpad("Interest rate ",25,".")).append(" ").append(Utils.double2s(this.getInterestRate() )).append("%").append("\n");
        sb.append(Utils.rpad("Duration ",25,".")).append(" ").append(this.getNumberOfInstallments()).append(" months").append("\n");
        sb.append(Utils.rpad("Monthly payments ",25,".")).append(" ").append(Utils.double2s(this.getSingleInstallmentAmount())).append("\n");
        sb.append(Utils.rpad("Intarest paid ",25,".")).append(" ").append(Utils.double2s(this.getInterestAmount())).append("\n");
        sb.append(Utils.rpad("Total paid ",25,".")).append(" ").append(Utils.double2s(this.getTotalAmount())).append("\n");

        sb.append("\n"); 
        
        sb.append( Utils.rpad( "Month", 5, " ")).append(" | ");
        sb.append( Utils.rpad( "Due date", x, " ") ).append(" | ");
        sb.append( Utils.rpad( "Installment", x, " ") ).append(" | ");
        sb.append( Utils.rpad( "Principal", x, " ") ).append(" | ");
        sb.append( Utils.rpad( "Interest", x, " ") ).append(" | ");
        sb.append( Utils.rpad( "Balance", x, " ")).append(" | ");
        sb.append( Utils.rpad( "Debt Paid", x, " ") ).append(" \n");
        sb.append(line);
        
        for ( Installment i : this.getInstallments() ){
            sb.append(Utils.rpad( ""+i.getNumber(), 5, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.date2s(i.getDueDate()), x, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.double2s(i.getTotalAmount()), x, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.double2s(i.getPrincipalAmount()), x, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.double2s(i.getInterestAmount()), x, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.double2s(i.getOutstandingPrincipal()), x, " ")).append(" | ");
            sb.append(Utils.rpad( Utils.double2s(i.getDebtPaid()), x, " ")).append(" \n");
        }
        sb.append(line);
        
        sb.append( Utils.rpad( "Total", 5, " ")).append("   ");
        sb.append( Utils.rpad( "", x, " ") ).append(" | ");
        sb.append( Utils.rpad( Utils.double2s(this.getTotalAmount()), x, " ") ).append(" | ");
        sb.append(Utils.rpad(Utils.double2s(this.getPrincipalAmount()), x, " ") ).append(" | ");
        sb.append( Utils.rpad( Utils.double2s(this.getInterestAmount()) , x, " ") ).append(" | ");
        sb.append( Utils.rpad( "", x, " ")).append("   ");
        sb.append( Utils.rpad( "", x, " ") ).append("\n");
        sb.append(line);
                
        return sb.toString();
    }
    
}
