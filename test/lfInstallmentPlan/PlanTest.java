/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package lfInstallmentPlan;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luca and Friends :: github.com/lfriends
 */
public class PlanTest {
    
    public PlanTest() {
    }

    @Test
    public void test1() {
        double principal = 10000;
        double rate = 7 ;
        int months = 12 ;

        System.out.println("---\nTest #1 principal:" + principal+" @ "+rate+"% x "+months+"months");
        
        Date date = lfInstallmentPlan.Utils.strf2date("31-12-23", "dd-MM-yy");
        double interest = 383.24 ;
        double total = principal + interest ;
        double single = 865.27 ;
        double temp = 0;

        Plan plan = new Plan(principal,months,rate,date,0);
         
        System.out.println("Checking input params ... ");                

        assertEquals( single*months, total , 0.0001);
        assertEquals( plan.getPrincipalAmount(), principal , 0.0001);
        assertEquals( plan.getInterestRatePerYearPercentage(), rate , 0.0001);
        assertEquals( plan.getNumberOfInstallments(), months );
        assertEquals( plan.getFirstDueDate(), date );     
        
        System.out.println("Checking totals ...");
        assertEquals(plan.getSingleInstallmentAmount(), single , 0.0001 );   
        assertEquals(plan.getPrincipalAmount(), principal , 0.0001);
        assertEquals(plan.getInterestAmount(), interest , 0.0001);
        assertEquals(plan.getTotalAmount(),  total , 0.0001);
        
        System.out.println("Recalculating total amount ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getPrincipalAmount()  ; 
        assertEquals( principal,temp , 0.0001);
        
        System.out.println("Recalculating total interest ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getInterestAmount()  ; 
        assertEquals(interest,temp  , 0.0001);
        
        System.out.println("Recalculating gran total ...");        
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getTotalAmount() ; 
        assertEquals(temp, total , 0.0001);
        
        System.out.println("Checking first installment ");         
        
        assertEquals( plan.getInstallments().get(0).getPrincipalAmount(), 806.94d , 0.0001 );
        assertEquals( plan.getInstallments().get(0).getInterestAmount(), 58.33d , 0.0001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingPrincipal(), 9193.06d , 0.0001 );
        
        System.out.println("Checking last installment ");
        
        assertEquals( plan.getLastDueDate(), lfInstallmentPlan.Utils.strf2date("30-11-24", "dd-MM-yy") );
        assertEquals( plan.getInstallments().get(months-1).getPrincipalAmount(), 860.21d , 0.0001 );
        assertEquals( plan.getInstallments().get(months-1).getInterestAmount(), 5.06d , 0.0001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingPrincipal(), 0d , 0.0001 );
    }

    

    @Test
    public void test2() {       
        
        double principal = 123456;
        double rate = 9.5 ;
        int months = 48 ;
        
        System.out.println("---\nTest #2 principal:" + principal+" @ "+rate+"% x "+months+"months");
        
        Date date = lfInstallmentPlan.Utils.strf2date("31-12-23", "dd-MM-yy");
        double interest = 25420.80 ;
        double total = principal + interest ;
        double single = 3101.60 ;
        double temp = 0;

        Plan plan = new Plan(principal,months,rate,date,0);
         
        System.out.println("Checking input params ... ");                

        assertEquals( single*months, total , 0.0001);
        assertEquals( plan.getPrincipalAmount(), principal , 0.0001);
        assertEquals( plan.getInterestRatePerYearPercentage(), rate , 0.0001);
        assertEquals( plan.getNumberOfInstallments(), months );
        assertEquals( plan.getFirstDueDate(), date );     
        
        System.out.println("Checking totals ...");
        assertEquals(plan.getSingleInstallmentAmount(), single , 0.0001 );   
        assertEquals(plan.getPrincipalAmount(), principal , 0.0001);
        assertEquals(plan.getInterestAmount(), interest , 0.0001);
        assertEquals(plan.getTotalAmount(),  total , 0.0001);
        
        System.out.println("Recalculating total amount ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getPrincipalAmount();
        assertEquals(temp, principal , 0.0001);
        
        System.out.println("Recalculating total interest ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getInterestAmount() ;
        assertEquals(temp, interest , 0.0001);
        
        System.out.println("Recalculating gran total ...");        
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getTotalAmount();
        assertEquals(temp, total , 0.0001);
        
        System.out.println("Checking first installment ");         
        
        assertEquals( plan.getInstallments().get(0).getPrincipalAmount(), 2124.24d , 0.0001 );
        assertEquals( plan.getInstallments().get(0).getInterestAmount(), 977.36d , 0.0001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingPrincipal(), 121331.76d , 0.0001 );
        
        System.out.println("Checking last installment ");
        
        assertEquals(plan.getLastDueDate(), lfInstallmentPlan.Utils.strf2date("30-11-27", "dd-MM-yy") );
        assertEquals( plan.getInstallments().get(months-1).getPrincipalAmount(), 3077.31d , 0.0001 );
        assertEquals( plan.getInstallments().get(months-1).getInterestAmount(), 24.29d , 0.0001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingPrincipal(), 0d , 0.0001 );
    }     
    
    
    
    @Test
    public void test3() {       
        
        double principal = 19000.36;
        double advancePayement = 0;
        double rate = 7.7 ;
        int months = 12 ;
        
        System.out.println("---\nTest #3 principal:" + principal+" @ "+rate+"% x "+months+"months"+" - adv payments: "+advancePayement);
        
        Date date = lfInstallmentPlan.Utils.strf2date("31-12-23", "dd-MM-yy");
        double interest = 801.80 ;
        double total = principal + interest  ;
        double single = 1650.18 ;
        double temp = 0;

        Plan plan = new Plan(principal,months,rate,date,advancePayement);
         
        System.out.println("Checking input params ... ");                

        assertEquals( single*months + advancePayement , total , 0.001);
        assertEquals( plan.getPrincipalAmount(), principal , 0.001);
        assertEquals( plan.getInterestRatePerYearPercentage(), rate , 0.001);
        assertEquals( plan.getNumberOfInstallments(), months );
        assertEquals( plan.getFirstDueDate(), date );     
        
        System.out.println("Checking totals ...");
        assertEquals(plan.getSingleInstallmentAmount(), single , 0.001 );   
        assertEquals(plan.getPrincipalAmount(), principal , 0.001);
        assertEquals(plan.getInterestAmount(), interest , 0.001);
        assertEquals(plan.getTotalAmount(),  total , 0.001);
        
        System.out.println("Recalculating total amount ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getPrincipalAmount();
        assertEquals(temp, principal , 0.001);
        
        System.out.println("Recalculating total interest ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getInterestAmount() ;
        assertEquals(temp, interest , 0.001);
        
        System.out.println("Recalculating gran total ...");        
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getTotalAmount();
        assertEquals(temp, total , 0.001);
        
        System.out.println("Checking first installment ");         
        
        assertEquals( plan.getInstallments().get(0).getPrincipalAmount(), 1528.26d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getInterestAmount(), 121.92d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getDebtPaid(),  1528.26d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingPrincipal(), 17472.10d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingInterests(), 679.88d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingTotal(), 18151.98d , 0.001 );
        
        System.out.println("Checking last installment ");
        
        assertEquals(plan.getLastDueDate(), lfInstallmentPlan.Utils.strf2date("30-11-24", "dd-MM-yy") );
        assertEquals( plan.getInstallments().get(months-1).getPrincipalAmount(), 1639.55d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getInterestAmount(), 10.63d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getDebtPaid(),  19000.36d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingPrincipal(), 0d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingInterests(), 0d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingTotal(), 0d , 0.001 );
    }    

    @Test
    public void test4() {       
        
        double principal = 19000.36;
        double advancePayement = 123.45;
        double rate = 7.7 ;
        int months = 12 ;
        double interest = 796.61 ;
        double single = 1639.46 ;
        
        System.out.println("---\nTest #4 principal:" + principal+" @ "+rate+"% x "+months+"months"+" - adv payments: "+advancePayement);
        
        Date date = lfInstallmentPlan.Utils.strf2date("31-12-23", "dd-MM-yy");
        double total = principal + interest  ;
        double temp = 0;

        Plan plan = new Plan(principal,months,rate,date,advancePayement);
             
        System.out.println("Checking input params ... ");                

        assertEquals( single*months + advancePayement , total , 0.001);
        assertEquals( plan.getPrincipalAmount(), principal , 0.001);
        assertEquals( plan.getInterestRatePerYearPercentage(), rate , 0.001);
        assertEquals( plan.getNumberOfInstallments(), months );
        assertEquals( plan.getFirstDueDate(), date );     
        
        System.out.println("Checking totals ...");
        assertEquals(plan.getSingleInstallmentAmount(), single , 0.001 );   
        assertEquals(plan.getPrincipalAmount(), principal , 0.001);
        assertEquals(plan.getInterestAmount(), interest , 0.001);
        assertEquals(plan.getTotalAmount(),  total , 0.001);
        
        System.out.println("Recalculating total amount ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getPrincipalAmount();
        assertEquals(principal-advancePayement ,temp,  0.001);
        
        System.out.println("Recalculating total interest ...");
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getInterestAmount() ;
        assertEquals(temp, interest , 0.001);
        
        System.out.println("Recalculating gran total ...");        
        temp = 0 ;
        for (Installment i: plan.getInstallments() )
            temp += i.getTotalAmount();
        assertEquals(total, temp+advancePayement , 0.001);
        
        System.out.println("Checking first installment ");         
        
        assertEquals( plan.getInstallments().get(0).getPrincipalAmount(), 1518.33d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getInterestAmount(), 121.13d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getDebtPaid(),  1518.33d , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingPrincipal(), 17358.58 , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingInterests(), 675.48 , 0.001 );
        assertEquals( plan.getInstallments().get(0).getOutstandingTotal(), 18034.06 , 0.001 );
        
        System.out.println("Checking last installment ");
        
        assertEquals(plan.getLastDueDate(), lfInstallmentPlan.Utils.strf2date("30-11-24", "dd-MM-yy") );
        assertEquals( plan.getInstallments().get(months-1).getPrincipalAmount(), 1628.95d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getInterestAmount(), 10.51d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getDebtPaid(),  18876.91d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingPrincipal(), 0d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingInterests(), 0d , 0.001 );
        assertEquals( plan.getInstallments().get(months-1).getOutstandingTotal(), 0d , 0.001 );
    }    
    
    
}
