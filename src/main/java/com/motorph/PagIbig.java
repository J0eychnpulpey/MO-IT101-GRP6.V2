package com.motorph;

// the PagIbig class is responsible for calculating the PagIbig deduction based on the employee's gross pay. It determine contribution rate.
public class PagIbig {
    double getPagibigDeduction(double grossPay) {
/*
If the monthly basic salary is atleast 1,000 to 1,500 therefore the employee's contribution rate is 1% the employer is 2%  overall total is 3%
If the monthly basic salary is over 1,500 the employee's contribution rate is 2% and the employer is 2%  the overall total is 2% 
Let say the employee 1 grossPay is 25,000 threfore the pagibig deduction is 100  NOTE: The maximum contribution amount is 100.     
*/
            double employeeContributionRate = (grossPay >= 1500) ? 0.02 : 0.01;
            double pagibigContribution= grossPay * employeeContributionRate;
        
             // Cap at 100 
            return Math.min(pagibigContribution, 100);
}
}

