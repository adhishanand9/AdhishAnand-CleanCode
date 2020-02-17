package org.example.interest;

public class SimpleInterest {
    public static float calculateInterest(float principal, float numberOfYears,float interestRate){
        if(principal==0||numberOfYears==0||interestRate==0)
            return -1;
        return Float.parseFloat(String.format("%.2f", principal*numberOfYears*interestRate/100));
    }
}
