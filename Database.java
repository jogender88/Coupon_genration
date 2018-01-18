/*import java.sql.*;

public class Database {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	Database() {
		try {

			// MAKE SURE YOU KEEP THE mysql_connector.jar file in java/lib
			// folder
			// ALSO SET THE CLASSPATH
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Coupon", "root", "");
			pst = con.prepareStatement("select * from user where Id=? and pass=?");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ip:username,password
	// return boolean
	public Boolean checkLogin(String Id,String pass)
    {
        try {
                        
            pst.setString(1, Id); //this replaces the 1st  "?" in the query for username
            pst.setString(2, pass);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            if(rs.next())
            {
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
}
}
*/