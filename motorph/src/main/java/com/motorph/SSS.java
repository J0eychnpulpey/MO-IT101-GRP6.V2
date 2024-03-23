package com.motorph;

public class SSS {

    double getSSSdeduction(double grossPay) {
        /*
        If the grossPay is 90,000 then the SSS deduction must be 1,125    
         */
           if (grossPay < 3250) {
            return 135.00;
        } else if (grossPay <= 3750) {
            return 157.50;
        } else if (grossPay <= 4250) {
            return 180.00;
        } else if (grossPay <= 4750) {
            return 202.50;
        } else if (grossPay <= 5250) {
            return 225.00;
        } else if (grossPay <= 5750) {
            return 247.50;
        } else if (grossPay <= 6250) {
            return 270.00;
        } else if (grossPay <= 6750) {
            return 292.50;
        } else if (grossPay <= 7250) {
            return 315.00;
        } else if (grossPay <= 7750) {
            return 337.50;
        } else if (grossPay <= 8250) {
            return 360.00;
        } else if (grossPay <= 8750) {
            return 382.50;
        } else if (grossPay <= 9250) {
            return 405.00;
        } else if (grossPay <= 9750) {
            return 427.50;
        } else if (grossPay <= 10250) {
            return 450.00;
        } else if (grossPay <= 10750) {
            return 472.50;
        } else if (grossPay <= 11250) {
            return 495.00;
        } else if (grossPay <= 11750) {
            return 517.50;
        } else if (grossPay <= 12250) {
            return 540.00;
        } else if (grossPay <= 12750) {
            return 562.50;
        } else if (grossPay <= 13250) {
            return 585.00;
        } else if (grossPay <= 13750) {
            return 607.50;
        } else if (grossPay <= 14250) {
            return 630.00;
        } else if (grossPay <= 14750) {
            return 652.50;
        } else if (grossPay <= 15250) {
            return 675.00;
        } else if (grossPay <= 15750) {
            return 697.50;
        } else if (grossPay <= 16250) {
            return 720.00;
        } else if (grossPay <= 16750) {
            return 742.50;
        } else if (grossPay <= 17250) {
            return 765.00;
        } else if (grossPay <= 17750) {
            return 787.50;
        } else if (grossPay <= 18250) {
            return 810.00;
        } else if (grossPay <= 18750) {
            return 832.50;
        } else if (grossPay <= 19250) {
            return 855.00;
        } else if (grossPay <= 19750) {
            return 877.5;
        } else if (grossPay <= 20250) {
            return 900.00;
        } else if (grossPay <= 20750) {
            return 922.50;
        } else if (grossPay <= 21250) {
            return 945.00;
        } else if (grossPay <= 21750) {
            return 967.50;
        } else if (grossPay <= 22250) {
            return 990.00;
        } else if (grossPay <= 22750) {
            return 1012.50;
        } else if (grossPay <= 23250) {
            return 1035.00;
        } else if (grossPay <= 23750) {
            return 1057.50; 
        } else if (grossPay <= 24250) {
            return 1080.00;
        } else if (grossPay <= 24750) {
            return 1102.50;
        } else if (grossPay > 24750) { 
            return 1125.00; 
        }

        // Handle unexpected input
        System.err.println("Error: Gross pay out of SSS table range!");
        return 0.0; 

        }   
}