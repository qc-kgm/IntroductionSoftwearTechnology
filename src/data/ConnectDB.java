package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static Connection connect;
	public static Connection toconnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connect=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QuanLiThongTinCovid","sa","1234");
		System.out.println("connect thanh cong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("connect error");
		}
		return connect;
	}
	
}
