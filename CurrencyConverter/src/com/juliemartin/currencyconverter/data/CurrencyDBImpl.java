package com.juliemartin.currencyconverter.data;

import com.juliemartin.currencyconverter.data.CurrencyData;
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
     * @return A CurrencyData object
     */
    @Override
    public CurrencyData getIdQueryRecord(String primaryKey) {

        String sql = "Select * from MONEY where CURRENCYCODE = ?";
        CurrencyData currencyData = new CurrencyData();
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = connection.prepareStatement(sql)) {
            pStatement.setString(1, primaryKey);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                if (resultSet.next()) {
                    currencyData.setCurrencyCode(resultSet.getString("CURRENCYCODE"));
                    currencyData.setSellPerCAD(resultSet.getDouble("SELLPERCAD"));
                    currencyData.setBuyPerCAD(resultSet.getDouble("BUYPERCAD"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return currencyData;
    }
}