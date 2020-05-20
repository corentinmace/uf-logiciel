package back;

import java.sql.*;

public class Db_connect {

	public static Connection con;
	
	public static void connexion() throws SQLException {
		
	
		 String url = "jdbc:mysql://192.168.2.10:3306/projet_uf?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

		 String utilisateur = "vpn";
		 String motDePasse = "Formation13@";
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, utilisateur, motDePasse);
			System.out.println("Connexion a la base de donnee etablie");
		} catch(Exception e) {System.out.println(e);}
		
	
	}
}

