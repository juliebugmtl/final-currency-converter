package com.juliemartin.currencyconverter.data;

/**
 *
 * @author Julie Martin
 */

public class RecordBean {

    private String currencyCode;
    private double sellPerCAD;
    private double buyPerCAD;
    
    public RecordBean(String currencyCode, double sellPerCAD, double buyPerCAD) {
        super();
        this.currencyCode = currencyCode;
        this.sellPerCAD = sellPerCAD;
        this.buyPerCAD = buyPerCAD;
    }

    public RecordBean() {
        super();
        this.currencyCode = "";
        this.sellPerCAD = -1;
        this.buyPerCAD = -1;

    }

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

    @Override
    public String toString() {
        String s =
        "Currency Code = " + currencyCode + "\n" +
        "Sell per CAD = " + sellPerCAD + "\n" +
        "Buy per CAD = " + buyPerCAD + "\n";
       
        return s;
    }
}
