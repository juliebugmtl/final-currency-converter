package com.juliemartin.currencyconverter.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julie Martin
 */
class CurrencyData {

 private String CURRENCYCODE;
    private double SELLPERCAD;
    private double BUYPERCAD;
    
    public CurrencyData(String CURRENCYCODE, double SELLPERCAD, double BUYPERCAD) {
        super();
        this.CURRENCYCODE = CURRENCYCODE;
        this.SELLPERCAD = SELLPERCAD;
        this.BUYPERCAD = BUYPERCAD;
    }


    public String getCurrencyCode() {
        return CURRENCYCODE;
    }

    public void setCurrencyCode(String CURRENCYCODE) {
        this.CURRENCYCODE = CURRENCYCODE;
    }

    public double SELLPERCAD() {
        return SELLPERCAD;
    }

    public void setSellPerCAD(double SELLPERCAD) {
        this.SELLPERCAD = SELLPERCAD;
    }

    public double BUYPERCAD() {
        return BUYPERCAD;
    }

    public void setBuyPerCAD(double BUYPERCAD) {
        this.BUYPERCAD = BUYPERCAD;
    }

    

    @Override
    public String toString() {
        String s =
        "Currency Code = " + CURRENCYCODE + "\n" +
        "Sell per CAD = " + SELLPERCAD + "\n" +
        "Buy per CAD = " + BUYPERCAD + "\n";

        return s;
    }
}