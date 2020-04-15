package back;

import java.sql.*;

public class Db_connect {

	public static Connection con;
	
	public static void connexion() throws SQLException {
		
	
		 String url = "jdbc:mysql://192.168.2.10:3306/test_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

		 String utilisateur = "vpn";
		 String motDePasse = "Formation13@";
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Connexion a la base de donnee etablie");
		} catch(Exception e) {System.out.println(e);}
		
		Statement statement = con.createStatement();
		ResultSet rs= statement.executeQuery("SELECT * FROM infos");
		
		while(rs.next()) {

			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
	
	}
}

