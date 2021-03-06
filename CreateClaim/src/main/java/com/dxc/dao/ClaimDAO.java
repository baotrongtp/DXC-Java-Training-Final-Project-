package com.dxc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dxc.model.Claim;
 

public class ClaimDAO {
	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ClaimDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean saveClaim(Claim claim) throws SQLException {
        String sql = "INSERT INTO Claim_Moto (Claim_No, Policy_No, Date_Occurred, Reserve_Currency, Reserve_Amount, Status) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, claim.getClaimNo());
        statement.setString(2, claim.getPolicyNo());
        statement.setDate(3, claim.getDateOccurred());
        statement.setString(4, claim.getReserveCurrency());
        statement.setString(5, claim.getReserveAmount());
        statement.setString(6, claim.getStatus());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public String getPreviousClaimID() throws SQLException {
        String claimNo = null;
        String sql = "SELECT top 1 Claim_No FROM Claim_Moto ORDER BY Claim_No DESC";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            claimNo = resultSet.getString("Claim_No");
             
        }
         
        resultSet.close();
        statement.close();
         
        return claimNo;
    }
    
    public boolean checkPolicyNumberExist(String policyNo) throws SQLException {
        String policyNumber = null;
        String sql = "SELECT Policy_No FROM Moto_Policy WHERE Policy_No = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, policyNo);
        
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            policyNumber = resultSet.getString("Policy_No");
             
        }
        
        resultSet.close();
        statement.close();
        if (policyNumber == null) {
			return false;
		}
        else {
			return true;
		}
    }
    
    public Boolean checkDateOnFallsInPolicyPeriod(java.util.Date dateOccurred, String policyNo) throws SQLException, ParseException {
        String status = null;
        String inceptionDate = null;
        String expiryDate = null; 
        java.util.Date inceptDate =null;
        java.util.Date expiDate = null;
        String sql = "SELECT Inception_Date, Expiry_Date FROM Moto_Policy WHERE Policy_No = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, policyNo);
        
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            inceptionDate = resultSet.getString("Inception_Date");
            expiryDate = resultSet.getString("Expiry_Date");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            inceptDate = sdf.parse(inceptionDate);
            expiDate = sdf.parse(expiryDate);
        }
        resultSet.close();
        statement.close();
    	if((dateOccurred.before(expiDate) == true) && (dateOccurred.after(inceptDate) == true)) {
    	    return true;
    	}
    	else {
			return false;
		}       
   
    }
    
    public boolean checkPolicyInForce(String policyNo) throws SQLException, ParseException {
        String status = null;
        String sql = "SELECT status FROM Moto_Policy WHERE Policy_No = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, policyNo);
        
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            status = resultSet.getString("status");
        }
        resultSet.close();
        statement.close();
        if (!status.equals("In Force")) {
        	return false;
        }
        else {
        	return true;
		}
        
   
    }
    
    public String compareReserveAmountWithSumInsured(String reserveAmount, String reserveCurrency, String policyNo) throws SQLException, ParseException {
        String sumInsured = null;
        String currency = null;
        String sql = "SELECT Sum_insured, Billing_Currency FROM Moto_Policy WHERE Policy_No = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, policyNo);
        
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	currency = resultSet.getString("Billing_Currency");
        	sumInsured = resultSet.getString("Sum_insured");
        }
        resultSet.close();
        statement.close();
        if (!currency.equals(reserveCurrency)) {
        	return currency;
        }
        else {
        	double sumInsured1 = Double.parseDouble(sumInsured);
        	double reserveAmount1 = Double.parseDouble(reserveAmount);
        	if (sumInsured1 < reserveAmount1) {
				return "0";
			}
        	else {
				return "1";
			}
		}
        
   
    }
    
}