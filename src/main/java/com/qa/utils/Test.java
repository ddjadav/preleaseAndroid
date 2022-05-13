package com.qa.utils;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

/**
 * @author Dilip
 * @created at 13-05-2022 14:09
 */
public class Test {
    public static void main(String[] args) {
        double purchase_price = 22300000;
        double stampDutyPercent = 0.049;  //4.90%
        double stampDuty = purchase_price * stampDutyPercent;
        System.out.println("StampDuty: "+stampDuty);
        double registrationChargesPercent=0.01; //1%
        double registrationCharges = stampDuty * registrationChargesPercent;
        System.out.println("RegCharge: "+registrationCharges);
        int legalCharges= 25000;
        double brokeragePercent= 0.02;  //2%
        double brokerageCharge = purchase_price * brokeragePercent;
        System.out.println("BrokCharge: "+brokerageCharge);
        int totalInvestment = (int) (purchase_price+stampDuty+registrationCharges+legalCharges+brokerageCharge);
        System.out.println("Total Investment: "+totalInvestment);

        int monthlyRent = 120645;
        int leasTenure = 9;


        double rentEsc = 0.15; //15%
//        Monthly_Rent_Over_Tenure = [120645,120645,120645,138742,138742,138742,159553,159553,159553]
        int security_deposit = 482580;
        System.out.println("Month: "+round(monthlyRent*rentEsc +monthlyRent));
        double[] cashflow = {120645,120645,120645,138742,138742,138742,159553,159553,159553};

        System.out.println("IRR: "+ Arrays.toString(cashFlow()));
//
    }
    public static double[] cashFlow(){
        double monthlyRent = 30000;
        double escPercent = 0.05 ;
        int escPeriod = 3;
        int  leasTenure = 9;
        double[] cashFlow = new double[leasTenure];
        int count = 0;
        int j = 0;
        while (count < escPeriod) {
            if (monthlyRent != 0) {
                if(count == 0) {
                    for (int i = 0; i < escPeriod; i++) {
                        cashFlow[i] = round(monthlyRent);
                        j++;
                    }
                }else if(count == 1 ) {
                    for (int i = 0; i < escPeriod; i++) {
                        double escCharge = monthlyRent * escPercent;
                        double totalMonthlyRent = escCharge + monthlyRent;
                        cashFlow[j] = round(totalMonthlyRent);
                        j++;
                    }
                }else {
                    for (int i = 0; i < escPeriod; i++) {
                        double tempMonthly = cashFlow[j-3];
                        double escCharge = tempMonthly * escPercent;
                        double totalMonthlyRent = escCharge + tempMonthly;
                        cashFlow[j] = round(totalMonthlyRent);
                        j++;
                    }
                }
            }
            count++;
        }
        return cashFlow;
    }


}
