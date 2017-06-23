package com.juliemartin.currencyconverter.data;

/**
 *
 * @author Julie Martin
 */
public class MoneyBean {

    private String currencyCode;
    private double amount;
    private double value;
    
    // Constructor
    
    public MoneyBean() {
        
    }

    // Getters and Setters

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}