package ResourceProvider;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
public static Connection getCon() {
	Connection con = DriverManager.getConnection();
}//
}
