package com.qa.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Math.round;

/**
 * @author Dilip
 * @created at 13-05-2022 18:18
 */
public class test2 {
    public static void main(String[] args) {
        rentOverTenure();
    }
    public static void rentOverTenure(){
        float monthlyRent = 30000;
        int leaseTenure = 9 ;
        int escalationEveryYear = 3;
        float escalationPercentage = 5;
        float rent = monthlyRent;
        int[] rentArray = new int[leaseTenure];

        if (escalationEveryYear > 0){
            for (int year = 1; year <= leaseTenure ; year += escalationEveryYear) {
                int escalation;
                float escalatedRent;
                int[] rentArrayTemp = new int[leaseTenure];
                if (year > 1){
                    escalation = round((rent * escalationPercentage)/100);
                    escalatedRent = round(rent) + escalation;
                    rent = escalatedRent;
                }
                if((year + escalationEveryYear <= leaseTenure) || (leaseTenure % escalationEveryYear)==0){
                     Arrays.fill(rentArrayTemp,0,escalationEveryYear,round(rent));
                }else {
                    escalation = (leaseTenure % escalationEveryYear);
                    Arrays.fill(rentArrayTemp,0,escalation,round(rent));
                }
                rentArray = mergeArray((rentArrayTemp.length),rentArray,rentArrayTemp);
            }
        }
        System.out.println(Arrays.toString(rentArray));
    }
    public static int[] mergeArray(int length,int[] firstArray,int[]secondArray){
        int[] mergedArray = new int[length];    //resultant array
        int pos = 0 ;
        for (int element : firstArray) //copying elements of secondArray using for-each loop
        {
            mergedArray[pos] = element;
            pos++;              //increases position by 1
        }
        int pos2 = 0;
        for (int element : secondArray) //copying elements of firstArray using for-each loop
        {
            mergedArray[pos2] = element;
            pos2++;
        }
        return mergedArray;
    }
}
/*
    function calculateRentOverTenure($monthlyRent, $leaseTenure, $escalationEveryYear, $escalationPercentage)
    {
        $rent = (float) $monthlyRent;
        $rentArray = [];
        if ($escalationEveryYear > 0) {
            for ($year = 1; $year <= $leaseTenure; $year += $escalationEveryYear) {
                if ($year > 1) {
                    $escalation = ($rent * $escalationPercentage) / 100;
                    $escalatedRent = round($rent) + $escalation; // remove round for more accurate value
                    $rent = $escalatedRent;
                }
                if (($year + $escalationEveryYear) <= $leaseTenure || ($leaseTenure % $escalationEveryYear) === 0) {
                    $rentArrayTemp = array_fill(0, $escalationEveryYear, round($rent));
                } else {
                    $escalation = ($leaseTenure % $escalationEveryYear);
                    $rentArrayTemp = array_fill(0, $escalation, round($rent));
                }
                $rentArray = array_merge($rentArray, $rentArrayTemp);
            }
        }

        return $rentArray;
    }



    function calculateCashFlow(array $rentOverTenureArray, $propertyPrice, $tenure, $propertyTax = 0, $propertyMaintenance = 0, $securityDeposit = 0)
    {
        $cashFlow = [];
        $cashFlow[] = $propertyPrice;

        foreach ($rentOverTenureArray as $index => $rentRecord) {
            $annualRent = $rentRecord * 12;
            $depositPercent = ($securityDeposit * 6) / 100;
            $totalInflow = $annualRent - $propertyTax - $propertyMaintenance + $depositPercent;

            // for last lease year
            if ($index === count($rentOverTenureArray) - 1) {
                $sellingPrice = calculateSellingPrice($propertyPrice, $tenure);
                $totalInflow = $totalInflow + $sellingPrice;
            }

            $cashFlow[] = round($totalInflow);
        }

        return $cashFlow;
    }



    function calculateSellingPrice($investmentPrice, $tenure, $appreciation = 7)
    {
        return $investmentPrice * pow(1 + $appreciation / 100, $tenure);
    }

function calculateIRR(array $cashFlow)
    {
        $maxIteration = 100;
        $guess = 0.0001;
        $investment = array_shift($cashFlow);
        $flow = $cashFlow;

        for ($n = 0; $n < $maxIteration; $n += $guess) {

            $pv = 0;
            for ($i = 0; $i < count($flow); $i++) {
                $pv = $pv + $flow[$i] / pow(1 + $n, $i + 1);
            }

            if ($pv <= $investment) {
                return round($n * 10000) / 100;
            }
        }
    }
*/