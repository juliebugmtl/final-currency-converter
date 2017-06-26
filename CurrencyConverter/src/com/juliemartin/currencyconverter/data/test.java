package com.juliemartin.currencyconverter.data;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
 
/**
 * This program demonstrates how to connect to Apache Derby (Java DB) database
 * for the embedded driver and network client driver.
 * @author www.codejava.net
 *
 */
public class test {
    
    String url = "jdbc:derby://localhost:1527/MONEYRECORDS";
    String user = "banker";
    String password = "finance";
 
        public ArrayList<RecordBean> getQueryRecords() {

        ArrayList<RecordBean> rows = new ArrayList<>();
        String sql = "Select * from MONEY";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery();) {
            while (resultSet.next()) {
                rows.add(new RecordBean(
                        resultSet.getString("CURRENCYCODE"),
                        resultSet.getDouble("BUYPERCAD"),
                        resultSet.getDouble("SELLPERCAD")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        
        
        
        System.out.println(rows);
        return rows;

        
    }
        
        

        

    
        
        
    private void testDatabase() {
        
    String query = "SELECT * FROM MONEY";
    
    try (
        Connection connection = DriverManager.getConnection(url, user, password);
        
           PreparedStatement pStatement = connection.prepareStatement(query);
           ResultSet resultSet = pStatement.executeQuery();) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                System.out.println("querying SELECT * FROM MONEY");
                int columnsNumber = rsmd.getColumnCount();
                       while (resultSet.next()) {
                           for (int i = 1; i <= columnsNumber; i++) {
                               if (i > 1) System.out.print(",  ");
                            String columnValue = resultSet.getString(i);
                            System.out.print(columnValue + " " + rsmd.getColumnName(i));
                        }
                        System.out.println("");
                    }

            

        
        // code
    
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    
       public void perform() {
        
          getQueryRecords();
        //testDatabase();
        
             
    }
    
    public static void main(String[] args) {
        test te = new test();
        te.perform();
        System.exit(0);
    }
    
}