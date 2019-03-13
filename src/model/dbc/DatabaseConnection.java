package model.dbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	private Connection conn=null;
	private static final String DRIVER = "com.mysql.jdbc.Driver";  
    private static final String USER = "root";  
    private static final String URL = "jdbc:mysql://localhost:3306/prosys?useUnicode=true&characterEncoding=utf8";  
    private static final String PASS = "123456";
    public DatabaseConnection() throws Exception 
    {
		Class.forName(DRIVER);
		conn=DriverManager.getConnection(URL, USER, PASS);
	}
    public Connection getConnection()
    {
    	return conn;
    }
    public void close() throws SQLException
    {
    	if(conn!=null)
    	{
    		conn.close();
    	}
    }

}


