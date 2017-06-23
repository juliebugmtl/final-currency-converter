package com.juliemartin.currencyconverter.data;

import com.juliemartin.currencyconverter.data.CurrencyData;

/**
 *
 * @author Julie Martin
 */
public interface CurrencyDB {

    /**
     *
     * @param primaryKey
     * @return
     */
    public CurrencyData getIdQueryRecord(String primaryKey);
}
