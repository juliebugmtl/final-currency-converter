package com.juliemartin.currencyconverter.data;

import com.juliemartin.currencyconverter.data.RecordBean;
import java.sql.*;

/**
 *
 * @author Julie Martin
 */

public class CurrencyDBImpl implements CurrencyDB {

    // Database connection information
    String url = "jdbc:derby://localhost:1527/MONEYRECORDS";
    String user = "banker";
    String password = "finance";

    public CurrencyDBImpl() {
        super();
    }

    /**
     * Connect to the database and pull data using the primary key (currencyCode)
     *
     * @param primaryKey
     * @return A RecordBean object
     */
    @Override
    public RecordBean getIdQueryRecord(String primaryKey) {

        String sql = "Select * from MONEY where CURRENCYCODE = ?";
        RecordBean record = new RecordBean();
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = connection.prepareStatement(sql)) {
            pStatement.setString(1, primaryKey);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                if (resultSet.next()) {
                    record.setCurrencyCode(resultSet.getString("CURRENCYCODE"));
                    record.setSellPerCAD(resultSet.getDouble("SELLPERCAD"));
                    record.setBuyPerCAD(resultSet.getDouble("BUYPERCAD"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return record;
        
    }
}