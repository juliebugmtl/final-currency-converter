package com.juliemartin.currencyconverter.data;

import com.juliemartin.currencyconverter.data.RecordBean;

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
    public RecordBean getIdQueryRecord(String primaryKey);
}
