package com.juliemartin.currencyconverter.calc;

import com.juliemartin.currencyconverter.data.MoneyBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Julie Martin
 */
public class Calculations {

    /**
     * Buying foreign currency with Canadian dollars
     *
     * @param money
     * @throws ArithmeticException
     */
    public void buyPerCAD(MoneyBean money) throws ArithmeticException {

        // Value is cost in Canadian dollars
        
        
        
        
        

        // At each step this variable is updated
        BigDecimal temp;
        // (1+rate)
        temp = BigDecimal.ONE.add(monthlyRate);

        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());

        // BigDecimal pow does not support negative exponents so divide 1 by the result
        temp = BigDecimal.ONE.divide(temp, MathContext.DECIMAL64);

        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);

        // rate / (1 - (1+rate)^-term)
        temp = monthlyRate.divide(temp, MathContext.DECIMAL64);

        // pv * (rate / 1 - (1+rate)^-term)
        temp = money.getInputValue().multiply(temp);

        // Round to 2 decimal places using banker's rounding
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);

        // Remove the sign if the result is negative
        money.setResult(temp.abs());
    }

    /**
     * Selling foreign currency for Canadian dollars
     *
     * @param money
     * @throws ArithmeticException
     */
    public void sellPerCAD(MoneyBean money) throws ArithmeticException {
        // Divide APR by 12
        BigDecimal monthlyRate = money.getRate().divide(new BigDecimal("12"), MathContext.DECIMAL64);

        // At each step this variable is updated
        BigDecimal temp;
        // (1+rate)
        temp = BigDecimal.ONE.add(monthlyRate);

        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());

        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);

        // (1 - (1+rate)^-term) / rate
        temp = temp.divide(monthlyRate, MathContext.DECIMAL64);

        // pv * (rate / 1 - (1+rate)^-term)
        temp = money.getInputValue().multiply(temp);

        // Round to 2 decimal places using banker's rounding
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);

        // Remove the sign if the result is negative
        money.setResult(temp.abs());

    }

}
