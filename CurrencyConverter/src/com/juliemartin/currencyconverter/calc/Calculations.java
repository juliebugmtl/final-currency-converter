package com.juliemartin.currencyconverter.calc;

import com.juliemartin.currencyconverter.data.MoneyBean;
import com.juliemartin.currencyconverter.data.RecordBean;
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
        
        double temp1 = money.getAmount();
        double temp2 = record.getBuyPerCAD();
        double temp3 = temp2*temp1;
        
        money.setValue(temp3);
    }
    /**
     * Selling foreign currency for Canadian dollars
     *
     * @param money
     * @throws ArithmeticException
     */
    public void sellPerCAD(MoneyBean money) throws ArithmeticException {
        
        // Value is money back in Canadian dollars
        
        double temp1 = money.getAmount();
        double temp2 = record.getSellPerCAD();
        double temp3 = temp2*temp1;
        
        money.setValue(temp3);
    }
        
}