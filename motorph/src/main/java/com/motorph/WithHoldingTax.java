package com.motorph;

public class WithHoldingTax {
    double getWithholdingTax(double grossSalary) {

        double withHoldingTax = 0;
        if (grossSalary > 20833 && grossSalary <= 33333) {
        withHoldingTax = (grossSalary - 20833) * 0.20;  
        } else if (grossSalary > 33333 && grossSalary <= 66666) { 
        withHoldingTax = 2500 + (grossSalary - 33333) * 0.25;  
        } else if (grossSalary > 66666 && grossSalary <= 166666) { 
        withHoldingTax = 10833 + (grossSalary - 66666) * 0.30; 
        } else if (grossSalary > 166666 && grossSalary <= 666666) { 
        withHoldingTax = 40833.33 + (grossSalary - 166666) * 0.32; 
        } else if (grossSalary > 666666) { 
        withHoldingTax = 200833.33 + (grossSalary - 666666) * 0.35; 
        } else { 
        withHoldingTax = 0.0; 
        } 
        return withHoldingTax;

}
}

