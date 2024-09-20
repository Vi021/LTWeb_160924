package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class SQLServerDBConnector {
	private final String serverName = "TTFE11\\SQLEXPRESS";
	private final String dbName = "WEPR_DefaultDB";
	private final String portnumber = "49172";
	private final String instance = ""; // empty if there is only one instance of SQL Server
	private final String username = "Vix";
	private final String password = "12345";

	public Connection getDBConnection() {
		Connection conn = null;

		try {
			String connStr = "jdbc:sqlserver://" + serverName + ":" + portnumber  + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
			
			if (!instance.isEmpty()) {
				connStr += ";instanceName=" + instance;
			}
			
			// Get the connection
			conn = DriverManager.getConnection(connStr, username, password);

			// Check if connection is successful
			if (conn != null) {
//				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//				System.out.println("[[ Driver name: " + dm.getDriverName());
//				System.out.println("Driver version: " + dm.getDriverVersion());
//				System.out.println("Product name: " + dm.getDatabaseProductName());
//				System.out.println("Product version: " + dm.getDatabaseProductVersion() + "]]");
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return conn;
	}

	// test run: right click -> Run as -> Java application
	public static void main(String[] args) {
		try {
			Connection conn = new SQLServerDBConnector().getDBConnection();
			if (conn != null) {
				System.out.println("Connection established successfully!");
			} else {
				System.out.println("Failed to establish connection.");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}