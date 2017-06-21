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

    String url = "jdbc:derby://localhost:1527/MONEY";
    String user = "banker";
    String password = "finance";
    
    public CurrencyData(int aInt, String string, String string1, String string2) {
        super();
    }

    /**
     * Retrieve all the records for a given table Return the data as an
     * array list of CurrencyData objects
     *
     * @param sql The SQL statement to execute
     * @return The array list
     */

    public ArrayList<CurrencyData> getQueryRecords() {

        ArrayList<CurrencyData> rows = new ArrayList<>();
        String sql = "Select * from CONVERTER";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery();) {
            while (resultSet.next()) {
                rows.add(new CurrencyData(
                        resultSet.getInt("ID"),
                        resultSet.getString("CURRENCYCODE"),
                        resultSet.getString("BUYPERCAD"),
                        resultSet.getString("SELLPERCAD")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return rows;
    }
}