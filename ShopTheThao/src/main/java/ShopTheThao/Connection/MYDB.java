package ShopTheThao.Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class MYDB {
	/*private final String serverName = "DESKTOP-VFV0DUA";
	private final String dbName = "ShopTheThao3";
	private final String username = "sa";
	private final String password = "123qwe";*/
	
	private final String serverName = "localhost";
	private final String dbName = "ShopTheThao";
	private final String username = "sa";
	private final String password = "Phu@0702";
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://"+ serverName+ ":1433"+";databaseName="+dbName;
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		return DriverManager.getConnection(url, username, password);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			System.out.println(new MYDB().getConnection().getMetaData());
		} catch (Exception e) {
			
		}
	}
	
	
}
