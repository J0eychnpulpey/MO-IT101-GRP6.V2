package com.motorph;

public class PhilHealth {
   
    double getPhilHealthDeduction(double grossPay) {
/*
-if the month basic salary  10,000 the premium rate is 3% therefore the monthlyt premium (deduction) would be 300
-if the month basic salary  10,000.001 to 59,999,99 the premium rate is 3% therefore the monthlyt premium (deduction) would be
300 up to 1800
- if the month basic salary  60,000 the premium rate is 3% therefore the monthlyt premium (deduction) would be 1800
Let say the grossPay is 25,000 therefore  it has 3% premium rate 750 on the other hand the employee share(50%) is 375
NOTE: Monthly premium contribution payments are equally shared between the employee and employer.      
*/
            double premiumRate = 0.03;
            double maxContribution = 1800.0; 
            double calculatedContribution = grossPay * premiumRate;
            double employeeShare = Math.min(calculatedContribution, maxContribution) / 2;
        
            return employeeShare;
}
}

