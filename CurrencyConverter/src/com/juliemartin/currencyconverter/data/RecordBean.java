package com.juliemartin.currencyconverter.data;

/**
 *
 * @author Julie Martin
 */
public class RecordBean {
    
    private String currencyCode;
    private double sellPerCAD;
    private double buyPerCAD;
    
    // Constructor
    
    public RecordBean(){
        
    }

    // Getters and Setters

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getSellPerCAD() {
        return sellPerCAD;
    }

    public void setSellPerCAD(double sellPerCAD) {
        this.sellPerCAD = sellPerCAD;
    }

    public double getBuyPerCAD() {
        return buyPerCAD;
    }

    public void setBuyPerCAD(double buyPerCAD) {
        this.buyPerCAD = buyPerCAD;
    }

}