package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import back.Db_connect;
import back.MenuQuartierController;

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
			
			NeededIdClient = rs.getString(1);
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
		
		System.out.println("Vous avez ajoute le quariter");
	}
	
	public static void read() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     1. Chercher un quartier      |");
		System.out.println("|----------------------------------|");
		System.out.println("|  2. Afficher tout les quartiers  |");
		System.out.println("|__________________________________|");
		
		
		String choices = sc.nextLine();
		switch(choices) {
		
		case "1":
			System.out.println(" __________________________________");
			System.out.println("|                                  |");
			System.out.println("|     Recherche d'un quartier      |");
			System.out.println("|__________________________________|");

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
				
				NeededIdClient = rs.getString(1);
	        }
	        
	        
	        Statement Statement2 = Db_connect.con.createStatement();    
	        ResultSet rs2=Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");
	        
	        while(rs2.next()) {
				System.out.println("| ID Bien : " + rs2.getString(2));
				System.out.println("|__________________________________________________________________________________|");
				
				NeededIdBien = rs2.getString(2);
				System.out.println(NeededIdBien);
				
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
			
			Statement statement4 = Db_connect.con.createStatement();
			ResultSet rs4 = statement4.executeQuery("SELECT * FROM quartier WHERE id_quartier='" + idQuartier + "'AND id_bien= '" + NeededIdBien + "'");
			
			while(rs4.next()) {

				System.out.println(" __________________________________________________________________________________");
				System.out.println("|                                                                                  |");
				System.out.println("| ID Bien : " + rs4.getString(1));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| ID Quartier : " + rs4.getString(2));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Code postal : " + rs4.getString(3));
				System.out.println("|__________________________________________________________________________________|");
				System.out.println("| Nom du quartier : " + rs4.getString(4));
				System.out.println("|__________________________________________________________________________________|");

			}

			break;

			case "2":
				Statement statement5 = Db_connect.con.createStatement();
				ResultSet rs5 = statement5.executeQuery("SELECT * FROM quartier");

				while(rs5.next()) {

					System.out.println(" __________________________________________________________________________________");
					System.out.println("|                                                                                  |");
					System.out.println("| ID Bien : " + rs5.getString(1));
					System.out.println("|----------------------------------------------------------------------------------|");
					System.out.println("| ID Quartier : " + rs5.getString(2));
					System.out.println("|----------------------------------------------------------------------------------|");
					System.out.println("| Code postal : " + rs5.getString(3));
					System.out.println("|__________________________________________________________________________________|");
					System.out.println("| Nom du quartier : " + rs5.getString(4));
					System.out.println("|__________________________________________________________________________________|");

				}


			
		}
		
		
		
	}
	
	public static void update() throws SQLException {

		Scanner sc = new Scanner(System.in);

		Db_connect.connexion();

		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|    Modification d'un quartier    |");
		System.out.println("|__________________________________|");

		System.out.println("Entrez le nom du client (existant) :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client (existant) :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de téléphone du client  (existant) :");
		String telClient = sc.nextLine();

		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");


		while (rs.next()) {
			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");

			NeededIdClient = rs.getString(1);
		}


		Statement Statement2 = Db_connect.con.createStatement();
		ResultSet rs2 = Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while (rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
			System.out.println(NeededIdBien);

		}

		System.out.println("Entrez le code postal de la ville :");
		idVille = sc.nextLine();

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM ville WHERE id_ville ='" + idVille + "'");

		while (rs3.next()) {

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

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM quartier WHERE id_quartier='" + idQuartier + "'AND id_bien= '" + NeededIdBien + "'");

		while (rs4.next()) {

			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Bien : " + rs4.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| ID Quartier : " + rs4.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Code postal : " + rs4.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nom du quartier : " + rs4.getString(4));
			System.out.println("|__________________________________________________________________________________|");

		}

		System.out.println("Que voulez vous modifier?");


		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|          1. Code postal          |");
		System.out.println("|----------------------------------|");
		System.out.println("|        2. Nom du quartier        |");
		System.out.println("|__________________________________|");

		String a = sc.nextLine();
		switch (a) {
			case "1":
				idVilleUpdate();
				break;
			case "2":
				nomQuartierUpdate();
				break;

		}



	}

	public static void idVilleUpdate() throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Quel est le nouveau code postal ?");
		String nouv = sc.nextLine();
		String nouvIdQuartier = null;

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM ville WHERE id_ville='" + nouv + "'");

		while(rs4.next()) {
				nouvIdQuartier = rs4.getString(1);
				System.out.println(nouvIdQuartier);
		}

		String req = "UPDATE quartier SET id_ville ='" + nouv + "' WHERE id_quartier =" + idQuartier + "";
		String req2 = "UPDATE quartier SET id_quartier_Ville ='" + nouvIdQuartier + "' WHERE id_quartier =" + idQuartier + "";
		String req3 = "UPDATE quartier SET id_quartier='" + nouvIdQuartier + "' WHERE id_quartier =" + idQuartier + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		PreparedStatement preparedStmt2 = Db_connect.con.prepareStatement(req2);
		preparedStmt2.execute();

		PreparedStatement preparedStmt3 = Db_connect.con.prepareStatement(req3);
		preparedStmt3.execute();

		System.out.println("Le code postal a bien ete change !");


	}

	public static void nomQuartierUpdate() throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Quel est le nouveau du quartier ?");
		String nouv = sc.nextLine();

		String nomQuartierReplaced=nouv.replace("'", "\\'");
		System.out.println(nomQuartierReplaced);

		String req = "UPDATE quartier SET nom_quartier ='" + nomQuartierReplaced + "' WHERE id_quartier =" + idQuartier + "";

		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();

		System.out.println("Le nom du quartier a bien ete change !");
	}
	
	public static void delete() throws SQLException {

		Scanner sc = new Scanner(System.in);

		Db_connect.connexion();

		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|    Suppresion d'un quartier      |");
		System.out.println("|__________________________________|");

		System.out.println("Entrez le nom du client (existant) :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client (existant) :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de téléphone du client  (existant) :");
		String telClient = sc.nextLine();

		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT id_client, nom_client, prenom_client FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");


		while (rs.next()) {
			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");

			NeededIdClient = rs.getString(1);
		}


		Statement Statement2 = Db_connect.con.createStatement();
		ResultSet rs2 = Statement2.executeQuery("SELECT * FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");

		while (rs2.next()) {
			System.out.println("| ID Bien : " + rs2.getString(2));
			System.out.println("|__________________________________________________________________________________|");

			NeededIdBien = rs2.getString(2);
			System.out.println(NeededIdBien);

		}

		System.out.println("Entrez le code postal de la ville :");
		idVille = sc.nextLine();

		Statement statement3 = Db_connect.con.createStatement();
		ResultSet rs3 = statement3.executeQuery("SELECT * FROM ville WHERE id_ville ='" + idVille + "'");

		while (rs3.next()) {

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

		Statement statement4 = Db_connect.con.createStatement();
		ResultSet rs4 = statement4.executeQuery("SELECT * FROM quartier WHERE id_quartier='" + idQuartier + "'AND id_bien= '" + NeededIdBien + "'");

		while (rs4.next()) {

			System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Bien : " + rs4.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| ID Quartier : " + rs4.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Code postal : " + rs4.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			System.out.println("| Nom du quartier : " + rs4.getString(4));
			System.out.println("|__________________________________________________________________________________|");

		}

		System.out.println("Voulez vous supprimer ce quartier ? (Y/N)");
		String a = sc.nextLine();

		switch (a) {
			case "Y":
				deleteYes();

				break;
			case "y":
				deleteYes();

				break;
			case "N":
				MenuQuartierController.QuartierControllerMenu();

				break;
			case "n":

				MenuQuartierController.QuartierControllerMenu();
				break;

		}
	}

	public static void deleteYes() throws SQLException {
		Statement statement2 = Db_connect.con.createStatement();
		statement2.executeUpdate("DELETE FROM quartier WHERE id_quartier=" + idQuartier + "");
		System.out.println("Le quartier à bien été supprimé");
		MenuQuartierController.QuartierControllerMenu();
	}
}
