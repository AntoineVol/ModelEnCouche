package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DbUtil {
	
	public static Connection seConnecter() throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost/bdclient";
		String login = "root";
		String password = "";
		Connection con = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,login,password);
		con.setAutoCommit(false);
		return con;
	}
	
	public static void seDeconnecter(Statement stat, ResultSet res, Connection con) {
		
		try {
			if(stat!=null) {stat.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(res!=null) {res.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(con!=null) {con.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
