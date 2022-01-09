package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class DB{
    
	private static DB dbInstance = null;
	private Connection conn = null;
	
	private DB()
	{
		
	}
	
	private void connect()
	{
        try {
            String dbUrl = "jdbc:sqlite:database.db";
            conn = DriverManager.getConnection(dbUrl);
            conn.setAutoCommit(true);
            System.out.println("DB Connected");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
	}
	
	public static DB getDB()
	{
		if(dbInstance == null)
		{
			dbInstance = new DB();
		}
		if( dbInstance.conn == null)
		{
			dbInstance.connect();
		}
		
		return dbInstance;
	}
	
	public boolean runStatement(String sql)
	{
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public boolean runStatement(String sql, SetDbParamsCallback setParamscallback )
	{
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			setParamscallback.call(pstmt);
			pstmt.executeUpdate();
			return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public void queryData(String sql, SetDbParamsCallback setParamscallback, ResultSetCallback resultSetCallback )
	{
		try
		{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
	        setParamscallback.call(pstmt);
	        ResultSet rs  = pstmt.executeQuery();
	        resultSetCallback.call(rs);	   
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    }
	}
	
}