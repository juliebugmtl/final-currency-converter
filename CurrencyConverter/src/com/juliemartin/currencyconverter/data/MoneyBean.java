package com.juliemartin.currencyconverter.data;

/**
 *
 * @author Julie Martin
 */
public class MoneyBean {

    private String currency;
    private double amount;
    private double value;
    
    // Constructor
    
    public MoneyBean() {

    }

    // Getters and Setters

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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