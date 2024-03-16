package com.grx10.solar.service;

import com.grx10.solar.model.Solar;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SolarService {

    public HashMap calculateSolar(Solar solar){

        HashMap values = new HashMap();
        int avgMonthlyBill = solar.getMonthlyBill();

        int noOfPanels = (int)Math.round(avgMonthlyBill/420.0);
        int requiredArea = noOfPanels * 2;
        double kW = (noOfPanels * 500)/1000.0;
        double capital = kW * 60000;

        int annualIncome = avgMonthlyBill * 12;
        int breakEvenYears = (int)Math.round(capital/annualIncome);

        double earnings = (annualIncome * 25) - capital;

        values.put("Number of Panels Needed", noOfPanels);
        values.put("Required Area of rooftop", requiredArea);
        values.put("Capital Needed", capital);
        values.put("Breakeven years", breakEvenYears);
        values.put("Next 25 years earnings", earnings);

         return values;
    }
}
