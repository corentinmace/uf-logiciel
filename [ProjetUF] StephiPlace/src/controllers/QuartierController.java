package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import back.Db_connect;

public class QuartierController {
	
	static String NeededIdClient = null;
	static String OldIdClient = null;
	static String NeededNomClient = null;
	static String NeededPrenomClient = null;
	static String NeededIdBien = null;
	static String idVille = null;
	static String idQuartier = null;
	
	public static void create() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrez le nom du client (existant) :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client (existant) :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de téléphone du client  (existant) :");
		String telClient = sc.nextLine();
		
        Statement statement = Db_connect.con.createStatement();    
        ResultSet rs=statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");
	
        
        while(rs.next()) {
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");
			
			OldIdClient = rs.getString(1);
        }
        
        
        Statement Statement2 = Db_connect.con.createStatement();    
        ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");
        
        while(rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");
			
			NeededIdBien = rs2.getString(2);
			
        	}	
        
    	System.out.println("Entrez le code postal de la ville :");
		idVille = sc.nextLine();
		
		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM ville WHERE id_ville ='" + idVille + "'");
		
		while(rs3.next()) {
			
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Quartier : " + rs3.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Code postal : " + rs3.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Ville : " + rs3.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			
			idQuartier = rs3.getString(1);
			
		}
        
		System.out.println("Entrez le nom du quartier :");
		String nomQuartier = sc.nextLine();
		
		String nomQuartierReplaced=nomQuartier.replace("'", "\\'");
		System.out.println(nomQuartierReplaced);
		
		Statement statement4 = Db_connect.con.createStatement();
		statement4.executeUpdate("INSERT INTO quartier VALUES('" + NeededIdBien + "','" + idQuartier + "','" + idVille + "','" + nomQuartierReplaced + "','" + idQuartier + "')");
		
		System.out.println("Vous avez ajouté le quariter");
	}
	
	public static void read() {
		
		
	}
	
	public static void update() {
		
		
	}
	
	public static void delete() {
		
	}

}
