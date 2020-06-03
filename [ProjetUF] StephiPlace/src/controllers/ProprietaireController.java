package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import back.Db_connect;
import back.MenuBienController;

public class ProprietaireController {
	
	static String NeededIdClient = null;
	static String OldIdClient = null;
	static String NeededNomClient = null;
	static String NeededPrenomClient = null;
	
	public static void create() throws SQLException {
		

		Random rand = new Random(); 
		int idBien = rand.nextInt((99999 - 1) + 1) + 1;
		System.out.println(idBien);
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entrez le nom du client (existant) :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client (existant) :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de telephone du client  (existant) :");
		String telClient = sc.nextLine();
		
        Statement statement = Db_connect.con.createStatement();    
        ResultSet rs=statement.executeQuery("SELECT * FROM client WHERE nom_client = '" + nomClient + "' AND prenom_client = '" + prenomClient + "' AND tel_client = '" + telClient + "'");
        
        while(rs.next()) {
        	System.out.println(" __________________________________________________________________________________");
			System.out.println("|                                                                                  |");
			System.out.println("| ID Client : " + rs.getString(1));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Nom : " + rs.getString(2));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Prenom : " + rs.getString(3));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Genre : " + rs.getString(4));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Date de naissance : " + rs.getString(5));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Image : " + rs.getString(6));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Telephone : " + rs.getString(7));
			System.out.println("|----------------------------------------------------------------------------------|");
			System.out.println("| Email : " + rs.getString(8));
			System.out.println("|----------------------------------------------------------------------------------|");
			
			
			NeededIdClient = rs.getString(1);
			NeededNomClient = rs.getString(2);
			NeededPrenomClient = rs.getString(3);
			
			
        }
        
        

		Statement statementIn = Db_connect.con.createStatement();
		statementIn.executeUpdate("INSERT INTO proprietaire (id_client, id_bien, id_client_relation1) VALUES ('" + NeededIdClient + "','" + idBien + "','" + NeededIdClient + "')");
        
        
        System.out.println("Vous avez cree un proprietaire pour le client " + NeededNomClient + " " + NeededPrenomClient + "(id client : " + NeededIdClient + ", id du bien : " + idBien + ")" );
        
        
        Db_connect.con.close();
        MenuBienController.BienControllerMenu();
		
	}
	
	public static void read() throws SQLException {
		
		Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|     Chercher un proprietaire     |");
		System.out.println("|__________________________________|");

			
			System.out.println("Entrez le nom du client (existant) :");
			String nomClient = sc.nextLine();
			System.out.println("Entrez le prenom du client (existant) :");
			String prenomClient = sc.nextLine();
			System.out.println("Entrez le numero de tele©phone du client  (existant) :");
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
	        	}	
	        
	        Db_connect.con.close();
	        MenuBienController.BienControllerMenu();
			
	}
	
	public static void update() throws SQLException {
	       
		
	}
	
	public static void delete() throws SQLException {
		
	Db_connect.connexion();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" __________________________________");
		System.out.println("|                                  |");
		System.out.println("|    Supprimer un proprietaire     |");
		System.out.println("|__________________________________|");
		
		System.out.println("Entrez le nom du client (existant) :");
		String nomClient = sc.nextLine();
		System.out.println("Entrez le prenom du client (existant) :");
		String prenomClient = sc.nextLine();
		System.out.println("Entrez le numero de tele©phone du client  (existant) :");
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
        	}
        
     	System.out.println("Voulez vous supprimer ce client ? (Y/N)");
        String a = sc.nextLine();
		
		switch(a) {
		case "Y":
			deleteYes();

			break;
		case "y":
			deleteYes();
			
			break;
		case "N":
			MenuBienController.BienControllerMenu();
			
			break;
		case "n":
			MenuBienController.BienControllerMenu();
			
			break;
			
			
		}
		
		Db_connect.con.close();
		MenuBienController.BienControllerMenu();
		
		
		
	}
	
	public static void deleteYes() throws SQLException {
		
		  Statement statement2 = Db_connect.con.createStatement();    
	      statement2.executeUpdate("DELETE FROM proprietaire WHERE id_client = '" + NeededIdClient + "'");
		
	}

}
