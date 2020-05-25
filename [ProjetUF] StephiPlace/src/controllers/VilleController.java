package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import back.Db_connect;
import back.MenuVilleController;

public class VilleController {
	
	static String idVille = null;
	
	public static void create() throws SQLException {
		
		Db_connect.connexion();
		
		Random rand = new Random(); 
		int idQuartier = rand.nextInt((99999 - 1) + 1) + 1;
		System.out.println(idQuartier);
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|      Création d'une ville        |");
		System.out.println("|__________________________________|");
		
		System.out.println("Entrez le code postal de la ville");
		idVille = sc.nextLine();
		System.out.println("Entrez le nom de la ville");
		String nomVille = sc.nextLine();
		
		String nomVilleReplaced=nomVille.replace("'", "\\'");
		System.out.println(nomVilleReplaced);
		
		Statement statement = Db_connect.con.createStatement();
		statement.executeUpdate("INSERT INTO ville VALUES(" + idQuartier +","+idVille+",'"+nomVilleReplaced+"')");
		
		System.out.println("La ville " + nomVille + " à bien été ajouté !");
		
		MenuVilleController.VilleControllerMenu();
		
	}
	
	public static void read() throws SQLException {
		
	Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     1. Chercher une ville        |");
		System.out.println("|----------------------------------|");
		System.out.println("|   2. Afficher toute les villes   |");
		System.out.println("|__________________________________|");
		
		String choices = sc.nextLine();
		switch(choices) {
		
		case "1":
		
			System.out.println("Entrez le code postal de la ville :");
			idVille = sc.nextLine();
			
			Statement statement = Db_connect.con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ville WHERE id_ville ='" + idVille + "'");
			
			while(rs.next()) {
				
	        	System.out.println(" __________________________________________________________________________________");
				System.out.println("|                                                                                  |");
				System.out.println("| ID Quartier : " + rs.getString(1));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Code postal : " + rs.getString(2));
				System.out.println("|----------------------------------------------------------------------------------|");
				System.out.println("| Ville : " + rs.getString(3));
				System.out.println("|__________________________________________________________________________________|");
				
			}
			
			MenuVilleController.VilleControllerMenu();
			break;
			
			
			case "2":
				
				Statement statement2 = Db_connect.con.createStatement();
				ResultSet rs2=statement2.executeQuery("SELECT * FROM ville");
				
				while(rs2.next()) {
					
		        	System.out.println(" __________________________________________________________________________________");
					System.out.println("|                                                                                  |");
					System.out.println("| ID Quartier : " + rs2.getString(1));
					System.out.println("|----------------------------------------------------------------------------------|");
					System.out.println("| Code postal : " + rs2.getString(2));
					System.out.println("|----------------------------------------------------------------------------------|");
					System.out.println("| Ville : " + rs2.getString(3));
					System.out.println("|__________________________________________________________________________________|");
					
				}
				
				MenuVilleController.VilleControllerMenu();
				break;
		}
		
	}
	
	public static void update() throws SQLException {
		
	Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     Modification d'une ville     |");
		System.out.println("|__________________________________|");
		
		System.out.println("Entrez le code postal de la ville :");
		idVille = sc.nextLine();
		
		Statement statement = Db_connect.con.createStatement();
		ResultSet rs=statement.executeQuery("SELECT * FROM ville WHERE id_ville='" + idVille + "'");
		
		while(rs.next()) {
			
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Quartier : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Code postal : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Ville : " + rs.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			
		}
		
		System.out.println("Que voulez vous modifier ?");
		
		System.out.println(" __________________________________________________________________________________");
		System.out.println("|                                                                                  |");
		System.out.println("| 1. Code Postal                                                                   |");
		System.out.println("|----------------------------------------------------------------------------------|");
		System.out.println("| 2. Nom de la ville                                                               |");
		System.out.println("|__________________________________________________________________________________|");
		
		String choices = sc.nextLine();
			switch(choices) {
			case "1":
				idVilleUpdate();
				break;
			
			case "2":
				nomVilleUpdate();
				break;
			}
		
	}
	
	public static void idVilleUpdate() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Rentrez le nouveau code postal de la ville");
		String nouv = sc.nextLine();
		
		String req = "UPDATE ville SET id_ville ='" + nouv + "' WHERE id_ville =" + idVille + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le code postal de la ville à bien été modifié par " + nouv);
		
		MenuVilleController.VilleControllerMenu();
		
	}
	
	public static void nomVilleUpdate() throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Rentrez le nouveau nom de la ville");
		String nouv = sc.nextLine();
		
		String req = "UPDATE ville SET nom_ville ='" + nouv + "' WHERE id_ville =" + idVille + "";
		
		PreparedStatement preparedStmt = Db_connect.con.prepareStatement(req);
		preparedStmt.execute();
		
		System.out.println("Le nom de la ville à bien été modifié par " + nouv);
		
		MenuVilleController.VilleControllerMenu();
		
	}
	
	
	
	public static void delete() throws SQLException {
		
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		

		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     Suppression d'une ville      |");
		System.out.println("|__________________________________|");
		
		
		System.out.println("Entrez le code postal de la ville :");
		idVille = sc.nextLine();
		
		Statement statement = Db_connect.con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM ville WHERE id_ville ='" + idVille + "'");
		
		while(rs.next()) {
			
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Quartier : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Code postal : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Ville : " + rs.getString(3));
			System.out.println("|__________________________________________________________________________________|");
			
		}
		
     	System.out.println("Voulez vous supprimer cette ville ? (Y/N)");
        String a = sc.nextLine();
		
		switch(a) {
		case "Y":
			deleteYes();

			break;
		case "y":
			deleteYes();
			
			break;
		case "N":
			MenuVilleController.VilleControllerMenu();
			
			break;
		case "n":
			MenuVilleController.VilleControllerMenu();
			
			break;
			
		}
        
		Db_connect.con.close();
		
	}
	
	
	public static void deleteYes() throws SQLException {
		  Statement statement2 = Db_connect.con.createStatement();    
	        statement2.executeUpdate("DELETE FROM ville WHERE id_ville = '" + idVille + "'");
	        MenuVilleController.VilleControllerMenu();
	}
	

}
