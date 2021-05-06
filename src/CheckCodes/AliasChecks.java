package CheckCodes;
import java.sql.*;
public class AliasChecks {
public static void main(String[] args)
{
try {
	Connection con = DriverManager.getConnection("","","");
	Statement stmt = con.createStatement();
	stmt.executeQuery("");
} catch (SQLException exception) {
	// TODO Auto-generated catch-block stub.
	exception.printStackTrace();
}	
}
}
